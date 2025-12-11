package portfolio_daniel_backend.infrastructure.mapper;

import portfolio_daniel_backend.domain.model.Project;
import portfolio_daniel_backend.infrastructure.entity.ProjectEntity;

public class ProjectJpaMapper {

    public static ProjectEntity toEntity(Project p) {
        var e = new ProjectEntity();
        e.setName(p.getName());
        e.setDescription(p.getDescription());
        e.setRole(p.getRole());
        e.setTechnologies(p.getTechnologies());
        e.setStartDate(p.getStartDate());
        e.setEndDate(p.getEndDate());
        e.setLink(p.getLink());
        e.setHighlight(p.isHighlight());
        return e;
    }

    public static Project toDomain(ProjectEntity e) {
        return new Project(
                e.getName(),
                e.getDescription(),
                e.getRole(),
                e.getTechnologies(),
                e.getStartDate(),
                e.getEndDate(),
                e.getLink(),
                e.isHighlight());
    }
}