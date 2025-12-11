package portfolio_daniel_backend.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import portfolio_daniel_backend.application.dto.ContactMessageDto;
import portfolio_daniel_backend.application.mapper.ContactMessageMapper;
import portfolio_daniel_backend.application.service.ContactMessageService;
import portfolio_daniel_backend.domain.repository.ContactMessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository repository;

    @Override
    public ContactMessageDto create(ContactMessageDto dto) {
        var saved = repository.save(ContactMessageMapper.toDomain(dto));
        return ContactMessageMapper.toDto(saved);
    }

    @Override
    public List<ContactMessageDto> list() {
        return repository.findAll()
                .stream()
                .map(ContactMessageMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}