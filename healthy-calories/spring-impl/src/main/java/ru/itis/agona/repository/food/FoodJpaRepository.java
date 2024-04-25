package ru.itis.agona.repository.food;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FoodEntity;

import java.util.UUID;

@Repository
public interface FoodJpaRepository extends JpaRepository<FoodEntity, UUID>, FoodRepository {
}
