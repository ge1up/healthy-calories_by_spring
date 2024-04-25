package ru.itis.agona.service.foodCategory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.agona.dto.request.FoodCategoryRequest;
import ru.itis.agona.dto.response.FoodCategoryResponse;
import ru.itis.agona.exception.badRequest.FoodCategoryBadRequestException;
import ru.itis.agona.exception.notFound.FoodCategoryNotFoundException;
import ru.itis.agona.mapper.FoodCategoryMapper;
import ru.itis.agona.model.FoodCategoryEntity;
import ru.itis.agona.repository.foodCategory.FoodCategoryRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {

    private final FoodCategoryRepository repository;

    private final FoodCategoryMapper mapper;

    @Override
    public Set<UUID> save(List<FoodCategoryRequest> foodCategoryRequests) {
        List<FoodCategoryEntity> foodCategories = new ArrayList<>();
        for (FoodCategoryRequest foodCategory : foodCategoryRequests) {
            foodCategories.add(mapper.toEntity(foodCategory));
        }
        try {
            return repository.save(foodCategories);
        } catch (Exception e) {
            throw new FoodCategoryBadRequestException();
        }
    }

    @Override
    public FoodCategoryResponse getById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new FoodCategoryNotFoundException(id))
        );
    }

    @Override
    public Set<FoodCategoryResponse> getAll() {
        Set<FoodCategoryResponse> foodCategories = new HashSet<>();
        for (FoodCategoryEntity foodCategory : repository.findAll()) {
            foodCategories.add(mapper.toResponse(foodCategory));
        }
        return foodCategories;
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void putById(UUID id, FoodCategoryRequest foodCategoryRequest) {
        repository.putById(id, mapper.toEntity(foodCategoryRequest));
    }

}
