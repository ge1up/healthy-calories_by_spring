package ru.itis.agona.service.eatenFood;

import ru.itis.agona.dto.request.EatenFoodRequest;
import ru.itis.agona.dto.response.EatenFoodResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface EatenFoodService {

    Set<UUID> save(List<EatenFoodRequest> eatenFoodRequests);

    EatenFoodResponse getById(UUID id);

    Set<EatenFoodResponse> getAll();

    void deleteById(UUID id);

    void putById(UUID id, EatenFoodRequest eatenFoodRequest);

}
