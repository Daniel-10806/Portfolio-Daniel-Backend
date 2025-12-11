package portfolio_daniel_backend.application.mapper;

import portfolio_daniel_backend.application.dto.ProjectDto;
import portfolio_daniel_backend.domain.model.Project;

public class ProjectMapper {

    public static Project toDomain(ProjectDto dto) {
        return new Project(
                dto.name(),
                dto.description(),
                dto.role(),
                dto.technologies(),
                dto.startDate(),
                dto.endDate(),
                dto.link(),
                dto.highlight());
    }

    public static Project toDomain(ProjectDto dto, Long id) {
        return new Project(
                dto.name(),
                dto.description(),
                dto.role(),
                dto.technologies(),
                dto.startDate(),
                dto.endDate(),
                dto.link(),
                dto.highlight());
    }

    public static ProjectDto toDto(Project p) {
        return new ProjectDto(
                p.getName(),
                p.getDescription(),
                p.getRole(),
                p.getTechnologies(),
                p.getStartDate(),
                p.getEndDate(),
                p.getLink(),
                p.isHighlight());
    }
}