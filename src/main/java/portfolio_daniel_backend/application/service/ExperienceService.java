package portfolio_daniel_backend.application.service;

import portfolio_daniel_backend.application.dto.ExperienceDto;
import java.util.List;
import java.util.Optional;

public interface ExperienceService {

    ExperienceDto create(ExperienceDto dto);

    List<ExperienceDto> list();

    ExperienceDto update(Long id, ExperienceDto dto);

    Optional<ExperienceDto> findById(Long id);

    void delete(Long id);
}