package portfolio_daniel_backend.interfaces.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portfolio_daniel_backend.application.dto.ExperienceDto;
import portfolio_daniel_backend.application.service.ExperienceService;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExperienceController {

    private final ExperienceService service;

    @PostMapping
    public ResponseEntity<ExperienceDto> create(@Valid @RequestBody ExperienceDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ExperienceDto dto) {

        var updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<ExperienceDto>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceDto> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}