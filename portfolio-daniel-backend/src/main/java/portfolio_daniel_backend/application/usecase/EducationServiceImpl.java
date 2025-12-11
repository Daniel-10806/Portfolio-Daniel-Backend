package portfolio_daniel_backend.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import portfolio_daniel_backend.application.dto.EducationDto;
import portfolio_daniel_backend.application.mapper.EducationMapper;
import portfolio_daniel_backend.application.service.EducationService;
import portfolio_daniel_backend.domain.repository.EducationRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository repository;

    @Override
    public EducationDto create(EducationDto dto) {
        var saved = repository.save(EducationMapper.toDomain(dto));
        return EducationMapper.toDto(saved);
    }

    @Override
    public List<EducationDto> list() {
        return repository.findAll()
                .stream()
                .map(EducationMapper::toDto)
                .toList();
    }

    @Override
    public EducationDto update(Long id, EducationDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Education not found"));

        var updated = repository.save(EducationMapper.toDomain(dto, id));
        return EducationMapper.toDto(updated);
    }

    @Override
    public Optional<EducationDto> findById(Long id) {
        return repository.findById(id)
                .map(EducationMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}