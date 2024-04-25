package ru.itis.agona.repository.user;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.agona.model.UserEntity;

import java.util.*;

@Repository

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID>, UserRepository {}
