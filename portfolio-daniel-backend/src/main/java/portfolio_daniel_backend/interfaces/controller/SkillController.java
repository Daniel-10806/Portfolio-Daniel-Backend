package portfolio_daniel_backend.interfaces.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import portfolio_daniel_backend.application.dto.SkillDto;
import portfolio_daniel_backend.application.service.SkillService;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SkillController {

    private final SkillService service;

    @PostMapping
    public ResponseEntity<SkillDto> create(@Valid @RequestBody SkillDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillDto> update(
            @PathVariable Long id,
            @Valid @RequestBody SkillDto dto) {

        var updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<SkillDto>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDto> findById(@PathVariable Long id) {
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