package portfolio_daniel_backend.application.mapper;

import portfolio_daniel_backend.application.dto.ExperienceDto;
import portfolio_daniel_backend.domain.model.Experience;

public class ExperienceMapper {

    public static Experience toDomain(ExperienceDto dto) {
        return new Experience(
                dto.company(),
                dto.position(),
                dto.location(),
                dto.startDate(),
                dto.endDate(),
                dto.current(),
                dto.description());
    }

    public static Experience toDomain(ExperienceDto dto, Long id) {
        return new Experience(
                dto.company(),
                dto.position(),
                dto.location(),
                dto.startDate(),
                dto.endDate(),
                dto.current(),
                dto.description());
    }

    public static ExperienceDto toDto(Experience e) {
        return new ExperienceDto(
                e.getCompany(),
                e.getPosition(),
                e.getLocation(),
                e.getStartDate(),
                e.getEndDate(),
                e.isCurrent(),
                e.getDescription());
    }
}