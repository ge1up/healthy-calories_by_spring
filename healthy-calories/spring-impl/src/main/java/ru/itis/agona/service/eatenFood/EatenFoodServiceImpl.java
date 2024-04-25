package ru.itis.agona.service.eatenFood;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.agona.dto.request.EatenFoodRequest;
import ru.itis.agona.dto.response.EatenFoodResponse;
import ru.itis.agona.exception.badRequest.EatenFoodBadRequestException;
import ru.itis.agona.exception.notFound.EatenFoodNotFoundException;
import ru.itis.agona.mapper.EatenFoodMapper;
import ru.itis.agona.model.EatenFoodEntity;
import ru.itis.agona.repository.eatenFood.EatenFoodRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EatenFoodServiceImpl implements EatenFoodService {

    private final EatenFoodRepository repository;

    private final EatenFoodMapper mapper;

    @Override
    public Set<UUID> save(List<EatenFoodRequest> eatenFoodRequests) {
        List<EatenFoodEntity> eatenFoods = new ArrayList<>();
        for (EatenFoodRequest eatenFood : eatenFoodRequests) {
            eatenFoods.add(mapper.toEntity(eatenFood));
        }
        try {
            return repository.save(eatenFoods);
        } catch (Exception e) {
            throw new EatenFoodBadRequestException();
        }
    }

    @Override
    public EatenFoodResponse getById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new EatenFoodNotFoundException(id))
        );
    }

    @Override
    public Set<EatenFoodResponse> getAll() {
        Set<EatenFoodResponse> eatenFoods = new HashSet<>();
        for (EatenFoodEntity eatenFood : repository.findAll()) {
            eatenFoods.add(mapper.toResponse(eatenFood));
        }
        return eatenFoods;
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void putById(UUID id, EatenFoodRequest eatenFoodRequest) {
        repository.putById(id, mapper.toEntity(eatenFoodRequest));
    }
}
