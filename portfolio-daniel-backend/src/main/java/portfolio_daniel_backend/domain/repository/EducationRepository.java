package portfolio_daniel_backend.domain.repository;

import portfolio_daniel_backend.domain.model.Education;

import java.util.List;
import java.util.Optional;

public interface EducationRepository {

    Education save(Education education);

    Optional<Education> findById(Long id);

    List<Education> findAll();

    void deleteById(Long id);
}