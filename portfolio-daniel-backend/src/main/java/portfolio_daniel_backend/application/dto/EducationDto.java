package portfolio_daniel_backend.application.dto;

import java.time.LocalDate;

public record EducationDto(
                String institution,
                String degree,
                String field,
                LocalDate startDate,
                LocalDate endDate,
                String status) {
}