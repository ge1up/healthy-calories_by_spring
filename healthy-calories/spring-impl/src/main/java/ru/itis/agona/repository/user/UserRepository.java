package ru.itis.agona.repository.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.EatenFoodEntity;
import ru.itis.agona.model.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserRepository {

    Set<UUID> save(List<UserEntity> userEntities);

    Optional<UserEntity> findById(UUID id);

    List<UserEntity> findAll();

    List<EatenFoodEntity> findEatenFoodsById(UUID id);

    List<UserEntity> getAll(int pageNumber, int pageSize, String direction, String name);

    void deleteById(UUID id);

    void putById(UUID id, UserEntity userEntity);

}
