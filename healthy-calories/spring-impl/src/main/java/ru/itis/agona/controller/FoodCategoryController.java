package ru.itis.agona.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.agona.api.FoodCategoryApi;
import ru.itis.agona.dto.request.FoodCategoryRequest;
import ru.itis.agona.dto.response.FoodCategoryResponse;
import ru.itis.agona.service.foodCategory.FoodCategoryService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FoodCategoryController implements FoodCategoryApi {

    private final FoodCategoryService service;


    @Override
    public Set<UUID> save(List<FoodCategoryRequest> foodCategoryRequests) {
        return service.save(foodCategoryRequests);
    }

    @Override
    public FoodCategoryResponse getById(UUID id) {
        return service.getById(id);
    }

    @Override
    public Set<FoodCategoryResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void deleteById(UUID id) {
        service.deleteById(id);
    }

    @Override
    public void putById(UUID id, FoodCategoryRequest foodCategoryRequest) {
        service.putById(id, foodCategoryRequest);
    }
}
