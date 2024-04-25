package ru.itis.agona.service.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.agona.dto.request.FoodRequest;
import ru.itis.agona.dto.request.FoodResponse;
import ru.itis.agona.exception.badRequest.FoodBadRequestException;
import ru.itis.agona.exception.notFound.FoodNotFoundException;
import ru.itis.agona.mapper.FoodMapper;
import ru.itis.agona.model.FoodEntity;
import ru.itis.agona.repository.food.FoodRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository repository;

    private final FoodMapper mapper;

    @Override
    public Set<UUID> save(List<FoodRequest> foodRequests) {
        List<FoodEntity> foods = new ArrayList<>();
        for (FoodRequest food : foodRequests) {
            foods.add(mapper.toEntity(food));
        }
        try {
            return repository.save(foods);
        } catch (Exception e) {
            throw new FoodBadRequestException();
        }
    }

    @Override
    public FoodResponse getById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new FoodNotFoundException(id))
        );
    }

    @Override
    public Set<FoodResponse> getAll() {
        Set<FoodResponse> foods = new HashSet<>();
        for (FoodEntity food : repository.findAll()) {
            foods.add(mapper.toResponse(food));
        }
        return foods;
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void putById(UUID id, FoodRequest foodRequest) {
        repository.putById(id, mapper.toEntity(foodRequest));
    }
}
