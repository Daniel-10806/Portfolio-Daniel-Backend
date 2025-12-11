package portfolio_daniel_backend.infrastructure.jpa;

import org.springframework.stereotype.Repository;
import portfolio_daniel_backend.domain.model.Project;
import portfolio_daniel_backend.domain.repository.ProjectRepository;
import portfolio_daniel_backend.infrastructure.mapper.ProjectJpaMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaProjectRepository implements ProjectRepository {

    private final SpringDataProjectRepository jpa;

    public JpaProjectRepository(SpringDataProjectRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Project save(Project project) {
        var entity = ProjectJpaMapper.toEntity(project);
        var saved = jpa.save(entity);
        return ProjectJpaMapper.toDomain(saved);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return jpa.findById(id).map(ProjectJpaMapper::toDomain);
    }

    @Override
    public List<Project> findAll() {
        return jpa.findAll()
                .stream()
                .map(ProjectJpaMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}