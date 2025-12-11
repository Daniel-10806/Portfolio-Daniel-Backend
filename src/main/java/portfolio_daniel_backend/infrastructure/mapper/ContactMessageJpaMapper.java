package portfolio_daniel_backend.infrastructure.mapper;

import portfolio_daniel_backend.domain.model.ContactMessage;
import portfolio_daniel_backend.infrastructure.entity.ContactMessageEntity;

public class ContactMessageJpaMapper {

    public static ContactMessageEntity toEntity(ContactMessage c) {
        var e = new ContactMessageEntity();
        e.setName(c.getName());
        e.setEmail(c.getEmail());
        e.setSubject(c.getSubject());
        e.setMessage(c.getMessage());
        e.setSentAt(c.getSentAt());
        e.setAttended(c.isAttended());
        return e;
    }

    public static ContactMessage toDomain(ContactMessageEntity e) {
        return new ContactMessage(
                e.getName(),
                e.getEmail(),
                e.getSubject(),
                e.getMessage(),
                e.getSentAt(),
                e.isAttended());
    }
}