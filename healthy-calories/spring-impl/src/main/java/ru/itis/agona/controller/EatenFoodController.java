package ru.itis.agona.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.agona.api.EatenFoodApi;
import ru.itis.agona.dto.request.EatenFoodRequest;
import ru.itis.agona.dto.response.EatenFoodResponse;
import ru.itis.agona.service.eatenFood.EatenFoodService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EatenFoodController implements EatenFoodApi {

    private final EatenFoodService service;


    @Override
    public Set<UUID> save(List<EatenFoodRequest> eatenFoodRequests) {
        return service.save(eatenFoodRequests);
    }

    @Override
    public EatenFoodResponse getById(UUID id) {
        return service.getById(id);
    }

    @Override
    public Set<EatenFoodResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void deleteById(UUID id) {
        service.deleteById(id);
    }

    @Override
    public void putById(UUID id, EatenFoodRequest eatenFoodRequest) {
        service.putById(id, eatenFoodRequest);
    }
}
