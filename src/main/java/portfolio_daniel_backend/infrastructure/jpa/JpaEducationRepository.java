package portfolio_daniel_backend.infrastructure.jpa;

import portfolio_daniel_backend.domain.model.Education;
import portfolio_daniel_backend.domain.repository.EducationRepository;
import portfolio_daniel_backend.infrastructure.mapper.EducationJpaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaEducationRepository implements EducationRepository {

    private final SpringDataEducationRepository jpa;

    public JpaEducationRepository(SpringDataEducationRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Education save(Education education) {
        var entity = EducationJpaMapper.toEntity(education);
        var saved = jpa.save(entity);
        return EducationJpaMapper.toDomain(saved);
    }

    @Override
    public Optional<Education> findById(Long id) {
        return jpa.findById(id).map(EducationJpaMapper::toDomain);
    }

    @Override
    public List<Education> findAll() {
        return jpa.findAll().stream()
                .map(EducationJpaMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}