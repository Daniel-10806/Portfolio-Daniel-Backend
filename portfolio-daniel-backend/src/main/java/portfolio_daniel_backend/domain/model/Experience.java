package portfolio_daniel_backend.domain.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entidad de dominio que representa una experiencia profesional.
 */
public class Experience {

    private Long id;
    private String company;
    private String position;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate; // null si es actual
    private boolean current;
    private String description;

    protected Experience() {
    }

    public Experience(
            String company,
            String position,
            String location,
            LocalDate startDate,
            LocalDate endDate,
            boolean current,
            String description) {

        if (company == null || company.isBlank()) {
            throw new IllegalArgumentException("El nombre de la empresa es obligatorio.");
        }
        if (position == null || position.isBlank()) {
            throw new IllegalArgumentException("El cargo es obligatorio.");
        }

        this.company = company;
        this.position = position;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.current = current;
        this.description = description;
    }

    public static Experience createWithoutId(String company,
            String position,
            String location,
            LocalDate startDate,
            LocalDate endDate,
            boolean current,
            String description) {
        return new Experience(company, position, location, startDate, endDate, current, description);
    }

    public String getCompany() {
        return company;
    }

    public void changeCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void changePosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void changeLocation(String location) {
        this.location = location;
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

    public boolean isCurrent() {
        return current;
    }

    public void markAsCurrent(boolean current) {
        this.current = current;
        if (current) {
            this.endDate = null;
        }
    }

    public String getDescription() {
        return description;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Experience))
            return false;
        Experience that = (Experience) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}