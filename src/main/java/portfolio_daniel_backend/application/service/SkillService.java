package portfolio_daniel_backend.application.service;

import portfolio_daniel_backend.application.dto.SkillDto;
import java.util.List;
import java.util.Optional;

public interface SkillService {

    SkillDto create(SkillDto dto);

    List<SkillDto> list();

    SkillDto update(Long id, SkillDto dto);

    Optional<SkillDto> findById(Long id);

    void delete(Long id);
}