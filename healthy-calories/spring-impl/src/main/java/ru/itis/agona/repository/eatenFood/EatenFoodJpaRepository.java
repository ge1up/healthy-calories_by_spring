package ru.itis.agona.repository.eatenFood;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.EatenFoodEntity;

import java.util.UUID;

@Repository
public interface EatenFoodJpaRepository extends JpaRepository<EatenFoodEntity, UUID>, EatenFoodRepository {
}
