package portfolio_daniel_backend.application.mapper;

import portfolio_daniel_backend.application.dto.SkillDto;
import portfolio_daniel_backend.domain.model.Skill;

public class SkillMapper {

    public static Skill toDomain(SkillDto dto) {
        return new Skill(
                dto.name(),
                dto.level(),
                dto.category(),
                dto.orderIndex());
    }

    public static Skill toDomain(SkillDto dto, Long id) {
        return new Skill(
                dto.name(),
                dto.level(),
                dto.category(),
                dto.orderIndex());
    }

    public static SkillDto toDto(Skill s) {
        return new SkillDto(
                s.getName(),
                s.getLevel(),
                s.getCategory(),
                s.getOrderIndex());
    }
}