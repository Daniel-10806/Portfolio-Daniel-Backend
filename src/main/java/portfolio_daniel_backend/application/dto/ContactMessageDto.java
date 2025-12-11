package portfolio_daniel_backend.application.dto;

import java.time.LocalDateTime;

public record ContactMessageDto(
                String name,
                String email,
                String subject,
                String message,
                LocalDateTime sentAt,
                boolean attended) {
}