package portfolio_daniel_backend.interfaces.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import portfolio_daniel_backend.application.dto.EducationDto;
import portfolio_daniel_backend.application.service.EducationService;

import java.util.List;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EducationController {

    private final EducationService service;

    @PostMapping
    public ResponseEntity<EducationDto> create(@Valid @RequestBody EducationDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationDto> update(
            @PathVariable Long id,
            @Valid @RequestBody EducationDto dto) {

        var updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<EducationDto>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationDto> findById(@PathVariable Long id) {
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