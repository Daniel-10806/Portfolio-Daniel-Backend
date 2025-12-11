package portfolio_daniel_backend.application.service;

import portfolio_daniel_backend.application.dto.ProjectDto;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    ProjectDto create(ProjectDto dto);

    List<ProjectDto> list();

    ProjectDto update(Long id, ProjectDto dto);

    Optional<ProjectDto> findById(Long id);

    void delete(Long id);
}