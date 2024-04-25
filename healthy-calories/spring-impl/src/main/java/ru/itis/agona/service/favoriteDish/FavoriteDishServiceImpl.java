package ru.itis.agona.service.favoriteDish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.agona.dto.request.FavoriteDishRequest;
import ru.itis.agona.dto.response.FavoriteDishResponse;
import ru.itis.agona.exception.badRequest.FavoriteDishBadRequestException;
import ru.itis.agona.exception.notFound.FavoriteDishNotFoundException;
import ru.itis.agona.mapper.FavoriteDishMapper;
import ru.itis.agona.model.FavoriteDishEntity;
import ru.itis.agona.repository.favoriteDish.FavoriteDishRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FavoriteDishServiceImpl implements FavoriteDishService {

    private final FavoriteDishRepository repository;

    private final FavoriteDishMapper mapper;

    @Override
    public Set<UUID> save(List<FavoriteDishRequest> favoriteDishRequests) {
        List<FavoriteDishEntity> favoriteDishes = new ArrayList<>();
        for (FavoriteDishRequest favoriteDish : favoriteDishRequests) {
            favoriteDishes.add(mapper.toEntity(favoriteDish));
        }
        try {
            return repository.save(favoriteDishes);
        } catch (Exception e) {
            throw new FavoriteDishBadRequestException();
        }
    }

    @Override
    public FavoriteDishResponse getById(UUID id) {
        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new FavoriteDishNotFoundException(id))
        );
    }

    @Override
    public Set<FavoriteDishResponse> getAll() {
        Set<FavoriteDishResponse> favoriteDishes = new HashSet<>();
        for (FavoriteDishEntity favoriteDish : repository.findAll()) {
            favoriteDishes.add(mapper.toResponse(favoriteDish));
        }
        return favoriteDishes;
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void putById(UUID id, FavoriteDishRequest favoriteDishRequest) {
        repository.putById(id, mapper.toEntity(favoriteDishRequest));
    }
}
