package portfolio_daniel_backend.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio_daniel_backend.infrastructure.entity.ExperienceEntity;

@Repository
public interface SpringDataExperienceRepository extends JpaRepository<ExperienceEntity, Long> {
}