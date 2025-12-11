package portfolio_daniel_backend.infrastructure.mapper;

import portfolio_daniel_backend.domain.model.Education;
import portfolio_daniel_backend.infrastructure.entity.EducationEntity;

public class EducationJpaMapper {

    public static EducationEntity toEntity(Education e) {
        var entity = new EducationEntity();
        entity.setInstitution(e.getInstitution());
        entity.setDegree(e.getDegree());
        entity.setField(e.getField());
        entity.setStartDate(e.getStartDate());
        entity.setEndDate(e.getEndDate());
        entity.setStatus(e.getStatus());
        return entity;
    }

    public static Education toDomain(EducationEntity e) {
        return new Education(
                e.getInstitution(),
                e.getDegree(),
                e.getField(),
                e.getStartDate(),
                e.getEndDate(),
                e.getStatus());
    }
}