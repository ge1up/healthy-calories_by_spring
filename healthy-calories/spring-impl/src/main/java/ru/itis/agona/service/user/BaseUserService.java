package ru.itis.agona.service.user;

import lombok.RequiredArgsConstructor;
import org.jooq.User;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ru.itis.agona.dto.request.UserRequest;
import ru.itis.agona.dto.response.EatenFoodResponse;
import ru.itis.agona.dto.response.UserResponse;
import ru.itis.agona.exception.badRequest.UserBadRequestException;
import ru.itis.agona.exception.notFound.UserNotFoundException;
import ru.itis.agona.mapper.EatenFoodMapper;
import ru.itis.agona.mapper.UserMapper;
import ru.itis.agona.model.EatenFoodEntity;
import ru.itis.agona.model.UserEntity;
import ru.itis.agona.repository.user.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseUserService implements UserService {

    private final UserRepository repository;

    private final UserMapper userMapper;
    private final EatenFoodMapper eatenFoodMapper;

    public Set<UUID> save(List<UserRequest> userRequests) {
        List<UserEntity> users = new ArrayList<>();
        for (UserRequest user : userRequests) {
            users.add(userMapper.toEntity(user));
        }
        try {
            return repository.save(users);
        } catch (Exception e) {
            throw new UserBadRequestException();
        }
    }

    @Override
    public UserResponse getById(UUID id) {
        return userMapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() -> new UserNotFoundException(id))
        );
    }

    @Override
    public Set<UserResponse> getAll() {
        Set<UserResponse> users = new HashSet<>();
        for (UserEntity user : repository.findAll()) {
            users.add(userMapper.toResponse(user));
        }
        return users;
    }

    @Override
    public Set<EatenFoodResponse> getEatenFoodsById(UUID id) {
        Set<EatenFoodResponse> foods = new HashSet<>();
        for (EatenFoodEntity food : repository.findEatenFoodsById(id)) {
            foods.add(eatenFoodMapper.toResponse(food));
        }
        return foods;
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void putById(UUID id, UserRequest userRequest) {
        repository.putById(id, mapper.toEntity(userRequest));
    }

    @Override
    public Set<UserResponse> getAll(int pageNumber, int pageSize, String direction, String name) {
        Set<UserResponse> users = new HashSet<>();
        for (UserEntity user : repository.getAll(pageNumber, pageSize, direction, name)) {
            users.add(userMapper.toResponse(user));
        }
        return users;
    }

}
