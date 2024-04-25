package ru.itis.agona.repository.foodCategory;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FoodCategoryEntity;

import java.util.UUID;

@Repository
@Primary
public interface FoodCategoryJpaRepository extends JpaRepository<FoodCategoryEntity, UUID>, FoodCategoryRepository {
}
