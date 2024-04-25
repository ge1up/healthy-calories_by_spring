package ru.itis.agona.repository.favoriteDish;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.FavoriteDishEntity;

import java.util.UUID;

@Repository
@Primary
public interface FavoriteDishJpaRepository extends JpaRepository<FavoriteDishEntity, UUID>, FavoriteDishRepository {
}
