package portfolio_daniel_backend.application.service;

import portfolio_daniel_backend.application.dto.ContactMessageDto;

import java.util.List;

public interface ContactMessageService {

    ContactMessageDto create(ContactMessageDto dto);

    List<ContactMessageDto> list();

    void delete(Long id);
}