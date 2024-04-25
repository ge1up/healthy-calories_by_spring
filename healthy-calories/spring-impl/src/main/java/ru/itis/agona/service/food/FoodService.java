package ru.itis.agona.service.food;

import ru.itis.agona.dto.request.FoodRequest;
import ru.itis.agona.dto.request.FoodResponse;
import ru.itis.agona.dto.request.UserRequest;
import ru.itis.agona.dto.response.UserResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface FoodService {

    Set<UUID> save(List<FoodRequest> foodRequests);

    FoodResponse getById(UUID id);

    Set<FoodResponse> getAll();

    void deleteById(UUID id);

    void putById(UUID id, FoodRequest foodRequest);

}
