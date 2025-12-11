package portfolio_daniel_backend.application.dto;

import java.time.LocalDate;

public record ExperienceDto(
                String company,
                String position,
                String location,
                LocalDate startDate,
                LocalDate endDate,
                boolean current,
                String description) {
}