package portfolio_daniel_backend.domain.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entidad de dominio que representa una formación académica.
 */
public class Education {

    private Long id;
    private String institution;
    private String degree; // Ej: "Bachiller en Ingeniería de Sistemas"
    private String field; // Ej: "Ingeniería de Software"
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // Ej: "En curso", "Finalizado"

    protected Education() {
    }

    public Education(
            String institution,
            String degree,
            String field,
            LocalDate startDate,
            LocalDate endDate,
            String status) {

        if (institution == null || institution.isBlank()) {
            throw new IllegalArgumentException("La institución es obligatoria.");
        }
        if (degree == null || degree.isBlank()) {
            throw new IllegalArgumentException("El grado o programa es obligatorio.");
        }

        this.institution = institution;
        this.degree = degree;
        this.field = field;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public static Education createWithoutId(String institution,
            String degree,
            String field,
            LocalDate startDate,
            LocalDate endDate,
            String status) {
        return new Education(institution, degree, field, startDate, endDate, status);
    }

    public String getInstitution() {
        return institution;
    }

    public void changeInstitution(String institution) {
        this.institution = institution;
    }

    public String getDegree() {
        return degree;
    }

    public void changeDegree(String degree) {
        this.degree = degree;
    }

    public String getField() {
        return field;
    }

    public void changeField(String field) {
        this.field = field;
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

    public String getStatus() {
        return status;
    }

    public void changeStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Education))
            return false;
        Education that = (Education) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}