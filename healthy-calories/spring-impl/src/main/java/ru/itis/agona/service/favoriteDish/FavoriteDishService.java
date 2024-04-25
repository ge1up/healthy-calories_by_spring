package ru.itis.agona.service.favoriteDish;

import ru.itis.agona.dto.request.FavoriteDishRequest;
import ru.itis.agona.dto.response.FavoriteDishResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface FavoriteDishService {

    Set<UUID> save(List<FavoriteDishRequest> favoriteDishRequests);

    FavoriteDishResponse getById(UUID id);

    Set<FavoriteDishResponse> getAll();

    void deleteById(UUID id);

    void putById(UUID id, FavoriteDishRequest favoriteDishRequest);

}
