package portfolio_daniel_backend.domain.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entidad de dominio que representa un proyecto del portafolio.
 */
public class Project {

    private Long id;
    private String name;
    private String description;
    private String role; // Rol desempeñado en el proyecto
    private String technologies; // Tecnologías principales (texto libre)
    private LocalDate startDate;
    private LocalDate endDate; // Puede ser null si sigue activo
    private String link; // GitHub, demo, etc.
    private boolean highlight; // Si debe mostrarse como destacado

    protected Project() {
        // Constructor protegido para frameworks o mapeadores
    }

    public Project(
            String name,
            String description,
            String role,
            String technologies,
            LocalDate startDate,
            LocalDate endDate,
            String link,
            boolean highlight) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del proyecto es obligatorio.");
        }
        this.name = name;
        this.description = description;
        this.role = role;
        this.technologies = technologies;
        this.startDate = startDate;
        this.endDate = endDate;
        this.link = link;
        this.highlight = highlight;
    }

    public static Project createWithoutId(String name,
            String description,
            String role,
            String technologies,
            LocalDate startDate,
            LocalDate endDate,
            String link,
            boolean highlight) {
        return new Project(name, description, role, technologies, startDate, endDate, link, highlight);
    }

    // Getters y setters de dominio

    public String getName() {
        return name;
    }

    public void rename(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del proyecto es obligatorio.");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void changeRole(String role) {
        this.role = role;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void changeTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void changeStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void changeEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLink() {
        return link;
    }

    public void changeLink(String link) {
        this.link = link;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    // Igualdad basada en id

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Project))
            return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}