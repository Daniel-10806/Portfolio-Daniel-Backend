package portfolio_daniel_backend.application.service;

import portfolio_daniel_backend.application.dto.EducationDto;

import java.util.List;
import java.util.Optional;

public interface EducationService {
    EducationDto create(EducationDto dto);

    List<EducationDto> list();

    EducationDto update(Long id, EducationDto dto);

    Optional<EducationDto> findById(Long id);

    void delete(Long id);
}