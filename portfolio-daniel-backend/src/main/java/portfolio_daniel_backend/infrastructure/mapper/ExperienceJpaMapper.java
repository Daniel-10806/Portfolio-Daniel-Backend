package portfolio_daniel_backend.infrastructure.mapper;

import portfolio_daniel_backend.domain.model.Experience;
import portfolio_daniel_backend.infrastructure.entity.ExperienceEntity;

public class ExperienceJpaMapper {

    public static ExperienceEntity toEntity(Experience e) {
        var entity = new ExperienceEntity();
        entity.setCompany(e.getCompany());
        entity.setPosition(e.getPosition());
        entity.setLocation(e.getLocation());
        entity.setStartDate(e.getStartDate());
        entity.setEndDate(e.getEndDate());
        entity.setCurrent(e.isCurrent());
        entity.setDescription(e.getDescription());
        return entity;
    }

    public static Experience toDomain(ExperienceEntity e) {
        return new Experience(
                e.getCompany(),
                e.getPosition(),
                e.getLocation(),
                e.getStartDate(),
                e.getEndDate(),
                e.isCurrent(),
                e.getDescription());
    }
}