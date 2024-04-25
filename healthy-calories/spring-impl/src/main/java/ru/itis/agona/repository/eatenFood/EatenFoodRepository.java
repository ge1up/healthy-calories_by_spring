package ru.itis.agona.repository.eatenFood;

import org.springframework.stereotype.Repository;
import ru.itis.agona.model.EatenFoodEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface EatenFoodRepository {

    Set<UUID> save(List<EatenFoodEntity> eatenFoodEntities);

    Optional<EatenFoodEntity> findById(UUID id);

    List<EatenFoodEntity> findAll();

    void deleteById(UUID id);

    void putById(UUID id, EatenFoodEntity eatenFoodEntity);

}
