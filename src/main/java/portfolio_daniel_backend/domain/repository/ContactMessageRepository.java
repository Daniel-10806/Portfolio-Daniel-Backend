package portfolio_daniel_backend.domain.repository;

import portfolio_daniel_backend.domain.model.ContactMessage;

import java.util.List;
import java.util.Optional;

public interface ContactMessageRepository {

    ContactMessage save(ContactMessage contactMessage);

    Optional<ContactMessage> findById(Long id);

    List<ContactMessage> findAll();

    void deleteById(Long id);
}