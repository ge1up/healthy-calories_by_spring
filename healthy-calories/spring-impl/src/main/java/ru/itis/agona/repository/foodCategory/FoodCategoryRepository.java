package ru.itis.agona.repository.foodCategory;

import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FoodCategoryEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface FoodCategoryRepository {

    Set<UUID> save(List<FoodCategoryEntity> foodCategoryEntities);

    Optional<FoodCategoryEntity> findById(UUID id);

    List<FoodCategoryEntity> findAll();

    void deleteById(UUID id);

    void putById(UUID id, FoodCategoryEntity foodCategoryEntity);

}
