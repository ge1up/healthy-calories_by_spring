package ru.itis.agona.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.agona.api.FoodApi;
import ru.itis.agona.dto.request.FoodRequest;
import ru.itis.agona.dto.request.FoodResponse;
import ru.itis.agona.service.food.FoodService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FoodController implements FoodApi {

    private final FoodService service;


    @Override
    public Set<UUID> save(List<FoodRequest> foodRequests) {
        return service.save(foodRequests);
    }

    @Override
    public FoodResponse getById(UUID id) {
        return service.getById(id);
    }

    @Override
    public Set<FoodResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void deleteById(UUID id) {
        service.deleteById(id);
    }

    @Override
    public void putById(UUID id, FoodRequest foodRequest) {
        service.putById(id, foodRequest);
    }
}
