package portfolio_daniel_backend.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import portfolio_daniel_backend.application.dto.ProjectDto;
import portfolio_daniel_backend.application.mapper.ProjectMapper;
import portfolio_daniel_backend.application.service.ProjectService;
import portfolio_daniel_backend.domain.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;

    @Override
    public ProjectDto create(ProjectDto dto) {
        var saved = repository.save(ProjectMapper.toDomain(dto));
        return ProjectMapper.toDto(saved);
    }

    @Override
    public List<ProjectDto> list() {
        return repository.findAll()
                .stream()
                .map(ProjectMapper::toDto)
                .toList();
    }

    @Override
    public ProjectDto update(Long id, ProjectDto dto) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        var updated = repository.save(ProjectMapper.toDomain(dto, id));
        return ProjectMapper.toDto(updated);
    }

    @Override
    public Optional<ProjectDto> findById(Long id) {
        return repository.findById(id)
                .map(ProjectMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}