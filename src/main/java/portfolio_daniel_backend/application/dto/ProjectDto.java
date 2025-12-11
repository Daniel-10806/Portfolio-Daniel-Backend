package portfolio_daniel_backend.application.dto;

import java.time.LocalDate;

public record ProjectDto(
                String name,
                String description,
                String role,
                String technologies,
                LocalDate startDate,
                LocalDate endDate,
                String link,
                boolean highlight) {
}