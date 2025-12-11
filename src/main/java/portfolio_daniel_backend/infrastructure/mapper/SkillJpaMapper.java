package portfolio_daniel_backend.infrastructure.mapper;

import portfolio_daniel_backend.domain.model.Skill;
import portfolio_daniel_backend.infrastructure.entity.SkillEntity;

public class SkillJpaMapper {

    public static SkillEntity toEntity(Skill s) {
        var e = new SkillEntity();
        e.setName(s.getName());
        e.setLevel(s.getLevel());
        e.setCategory(s.getCategory());
        e.setOrderIndex(s.getOrderIndex());
        return e;
    }

    public static Skill toDomain(SkillEntity e) {
        return new Skill(
                e.getName(),
                e.getLevel(),
                e.getCategory(),
                e.getOrderIndex());
    }
}