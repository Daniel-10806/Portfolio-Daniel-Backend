package portfolio_daniel_backend.application.mapper;

import portfolio_daniel_backend.application.dto.EducationDto;
import portfolio_daniel_backend.domain.model.Education;

public class EducationMapper {

    public static Education toDomain(EducationDto dto) {
        return new Education(
                dto.institution(),
                dto.degree(),
                dto.field(),
                dto.startDate(),
                dto.endDate(),
                dto.status());
    }

    public static Education toDomain(EducationDto dto, Long id) {
        return new Education(
                dto.institution(),
                dto.degree(),
                dto.field(),
                dto.startDate(),
                dto.endDate(),
                dto.status());
    }

    public static EducationDto toDto(Education e) {
        return new EducationDto(
                e.getInstitution(),
                e.getDegree(),
                e.getField(),
                e.getStartDate(),
                e.getEndDate(),
                e.getStatus());
    }
}