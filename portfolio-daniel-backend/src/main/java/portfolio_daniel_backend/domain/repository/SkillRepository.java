package portfolio_daniel_backend.domain.repository;

import portfolio_daniel_backend.domain.model.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillRepository {

    Skill save(Skill skill);

    Optional<Skill> findById(Long id);

    List<Skill> findAll();

    void deleteById(Long id);
}