package portfolio_daniel_backend.interfaces.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import portfolio_daniel_backend.application.dto.ContactMessageDto;
import portfolio_daniel_backend.application.service.ContactMessageService;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContactMessageController {

    private final ContactMessageService service;

    @PostMapping
    public ResponseEntity<ContactMessageDto> send(@Valid @RequestBody ContactMessageDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ContactMessageDto>> list() {
        return ResponseEntity.ok(service.list());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}