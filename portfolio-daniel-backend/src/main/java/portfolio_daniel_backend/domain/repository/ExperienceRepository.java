package portfolio_daniel_backend.domain.repository;

import portfolio_daniel_backend.domain.model.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceRepository {

    Experience save(Experience experience);

    Optional<Experience> findById(Long id);

    List<Experience> findAll();

    void deleteById(Long id);
}