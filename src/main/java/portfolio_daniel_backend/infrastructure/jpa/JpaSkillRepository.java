package portfolio_daniel_backend.infrastructure.jpa;

import portfolio_daniel_backend.domain.model.Skill;
import portfolio_daniel_backend.domain.repository.SkillRepository;
import portfolio_daniel_backend.infrastructure.mapper.SkillJpaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaSkillRepository implements SkillRepository {

    private final SpringDataSkillRepository jpa;

    public JpaSkillRepository(SpringDataSkillRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Skill save(Skill skill) {
        var entity = SkillJpaMapper.toEntity(skill);
        var saved = jpa.save(entity);
        return SkillJpaMapper.toDomain(saved);
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return jpa.findById(id).map(SkillJpaMapper::toDomain);
    }

    @Override
    public List<Skill> findAll() {
        return jpa.findAll().stream()
                .map(SkillJpaMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}