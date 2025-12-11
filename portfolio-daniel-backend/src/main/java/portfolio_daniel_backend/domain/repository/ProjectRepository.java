package portfolio_daniel_backend.domain.repository;

import portfolio_daniel_backend.domain.model.Project;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de repositorio de dominio para proyectos.
 */
public interface ProjectRepository {

    Project save(Project project);

    Optional<Project> findById(Long id);

    List<Project> findAll();

    void deleteById(Long id);
}