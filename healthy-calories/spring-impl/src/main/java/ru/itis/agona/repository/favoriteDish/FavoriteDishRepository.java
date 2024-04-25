package ru.itis.agona.repository.favoriteDish;

import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FavoriteDishEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface FavoriteDishRepository {

    Set<UUID> save(List<FavoriteDishEntity> favoriteDishEntities);

    Optional<FavoriteDishEntity> findById(UUID id);

    List<FavoriteDishEntity> findAll();

    void deleteById(UUID id);

    void putById(UUID id, FavoriteDishEntity favoriteDishEntity);

}
