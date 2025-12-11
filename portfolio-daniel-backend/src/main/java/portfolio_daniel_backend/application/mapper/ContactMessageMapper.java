package portfolio_daniel_backend.application.mapper;

import portfolio_daniel_backend.application.dto.ContactMessageDto;
import portfolio_daniel_backend.domain.model.ContactMessage;

public class ContactMessageMapper {

    public static ContactMessageDto toDto(ContactMessage cm) {
        return new ContactMessageDto(
                cm.getName(),
                cm.getEmail(),
                cm.getSubject(),
                cm.getMessage(),
                cm.getSentAt(),
                cm.isAttended());
    }

    public static ContactMessage toDomain(ContactMessageDto dto) {
        return new ContactMessage(
                dto.name(),
                dto.email(),
                dto.subject(),
                dto.message(),
                dto.sentAt(),
                dto.attended());
    }
}