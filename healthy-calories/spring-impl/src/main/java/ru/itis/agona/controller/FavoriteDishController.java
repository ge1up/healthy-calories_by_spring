package ru.itis.agona.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.agona.api.FavoriteDishApi;
import ru.itis.agona.dto.request.FavoriteDishRequest;
import ru.itis.agona.dto.response.FavoriteDishResponse;
import ru.itis.agona.service.favoriteDish.FavoriteDishService;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FavoriteDishController implements FavoriteDishApi {

    private final FavoriteDishService service;


    @Override
    public Set<UUID> save(List<FavoriteDishRequest> favoriteDishRequests) {
        return service.save(favoriteDishRequests);
    }

    @Override
    public FavoriteDishResponse getById(UUID id) {
        return service.getById(id);
    }

    @Override
    public Set<FavoriteDishResponse> getAll() {
        return service.getAll();
    }

    @Override
    public void deleteById(UUID id) {
        service.deleteById(id);
    }

    @Override
    public void putById(UUID id, FavoriteDishRequest favoriteDishRequest) {
        service.putById(id, favoriteDishRequest);
    }
}
