package portfolio_daniel_backend.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import portfolio_daniel_backend.application.dto.ExperienceDto;
import portfolio_daniel_backend.application.mapper.ExperienceMapper;
import portfolio_daniel_backend.application.service.ExperienceService;
import portfolio_daniel_backend.domain.repository.ExperienceRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository repository;

    @Override
    public ExperienceDto create(ExperienceDto dto) {
        var saved = repository.save(ExperienceMapper.toDomain(dto));
        return ExperienceMapper.toDto(saved);
    }

    @Override
    public List<ExperienceDto> list() {
        return repository.findAll()
                .stream()
                .map(ExperienceMapper::toDto)
                .toList();
    }

    @Override
    public ExperienceDto update(Long id, ExperienceDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experience not found"));

        var updated = repository.save(ExperienceMapper.toDomain(dto, id));
        return ExperienceMapper.toDto(updated);
    }

    @Override
    public Optional<ExperienceDto> findById(Long id) {
        return repository.findById(id)
                .map(ExperienceMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}