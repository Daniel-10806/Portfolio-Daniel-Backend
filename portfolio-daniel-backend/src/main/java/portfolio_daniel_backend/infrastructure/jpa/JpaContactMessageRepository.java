package portfolio_daniel_backend.infrastructure.jpa;

import portfolio_daniel_backend.domain.model.ContactMessage;
import portfolio_daniel_backend.domain.repository.ContactMessageRepository;
import portfolio_daniel_backend.infrastructure.mapper.ContactMessageJpaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaContactMessageRepository implements ContactMessageRepository {

    private final SpringDataContactMessageRepository jpa;

    public JpaContactMessageRepository(SpringDataContactMessageRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public ContactMessage save(ContactMessage contactMessage) {
        var entity = ContactMessageJpaMapper.toEntity(contactMessage);
        var saved = jpa.save(entity);
        return ContactMessageJpaMapper.toDomain(saved);
    }

    @Override
    public Optional<ContactMessage> findById(Long id) {
        return jpa.findById(id).map(ContactMessageJpaMapper::toDomain);
    }

    @Override
    public List<ContactMessage> findAll() {
        return jpa.findAll().stream()
                .map(ContactMessageJpaMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}