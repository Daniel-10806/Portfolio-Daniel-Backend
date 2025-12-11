package portfolio_daniel_backend.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portfolio_daniel_backend.infrastructure.entity.SkillEntity;

@Repository
public interface SpringDataSkillRepository extends JpaRepository<SkillEntity, Long> {
}