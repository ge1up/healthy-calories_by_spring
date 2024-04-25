package ru.itis.agona.repository.food;

import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FoodEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface FoodRepository {

    Set<UUID> save(List<FoodEntity> foodEntities);

    Optional<FoodEntity> findById(UUID id);

    List<FoodEntity> findAll();

    void deleteById(UUID id);

    void putById(UUID id, FoodEntity foodEntity);
    
}
