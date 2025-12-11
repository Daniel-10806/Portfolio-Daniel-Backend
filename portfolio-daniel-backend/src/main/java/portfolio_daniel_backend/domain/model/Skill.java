package portfolio_daniel_backend.domain.model;

import java.util.Objects;

/**
 * Entidad de dominio que representa una habilidad.
 */
public class Skill {

    private Long id;
    private String name; // Ej: "Spring Boot", "Angular", "Docker"
    private String level; // Ej: "Básico", "Intermedio", "Avanzado"
    private String category; // Ej: "Backend", "Frontend", "DevOps"
    private Integer orderIndex; // Para ordenar en el portafolio

    protected Skill() {
    }

    public Skill(
            String name,
            String level,
            String category,
            Integer orderIndex) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre de la habilidad es obligatorio.");
        }

        this.name = name;
        this.level = level;
        this.category = category;
        this.orderIndex = orderIndex;
    }

    public static Skill createWithoutId(String name,
            String level,
            String category,
            Integer orderIndex) {
        return new Skill(name, level, category, orderIndex);
    }

    public String getName() {
        return name;
    }

    public void rename(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void changeLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void changeCategory(String category) {
        this.category = category;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void changeOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Skill))
            return false;
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}