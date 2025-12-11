package portfolio_daniel_backend.infrastructure.jpa;

import portfolio_daniel_backend.domain.model.Experience;
import portfolio_daniel_backend.domain.repository.ExperienceRepository;
import portfolio_daniel_backend.infrastructure.mapper.ExperienceJpaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaExperienceRepository implements ExperienceRepository {

    private final SpringDataExperienceRepository jpa;

    public JpaExperienceRepository(SpringDataExperienceRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Experience save(Experience experience) {
        var entity = ExperienceJpaMapper.toEntity(experience);
        var saved = jpa.save(entity);
        return ExperienceJpaMapper.toDomain(saved);
    }

    @Override
    public Optional<Experience> findById(Long id) {
        return jpa.findById(id).map(ExperienceJpaMapper::toDomain);
    }

    @Override
    public List<Experience> findAll() {
        return jpa.findAll().stream()
                .map(ExperienceJpaMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}