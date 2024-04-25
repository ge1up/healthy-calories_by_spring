package ru.itis.agona.service.foodCategory;

import ru.itis.agona.dto.request.FoodCategoryRequest;
import ru.itis.agona.dto.response.FoodCategoryResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface FoodCategoryService {

    Set<UUID> save(List<FoodCategoryRequest> foodCategoryRequests);

    FoodCategoryResponse getById(UUID id);

    Set<FoodCategoryResponse> getAll();

    void deleteById(UUID id);

    void putById(UUID id, FoodCategoryRequest foodCategoryRequest);

}
