package portfolio_daniel_backend.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import portfolio_daniel_backend.application.dto.SkillDto;
import portfolio_daniel_backend.application.mapper.SkillMapper;
import portfolio_daniel_backend.application.service.SkillService;
import portfolio_daniel_backend.domain.repository.SkillRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repository;

    @Override
    public SkillDto create(SkillDto dto) {
        var saved = repository.save(SkillMapper.toDomain(dto));
        return SkillMapper.toDto(saved);
    }

    @Override
    public List<SkillDto> list() {
        return repository.findAll()
                .stream()
                .map(SkillMapper::toDto)
                .toList();
    }

    @Override
    public SkillDto update(Long id, SkillDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        var updated = repository.save(SkillMapper.toDomain(dto, id));
        return SkillMapper.toDto(updated);
    }

    @Override
    public Optional<SkillDto> findById(Long id) {
        return repository.findById(id)
                .map(SkillMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}