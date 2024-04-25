package ru.itis.agona.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ru.itis.agona.dto.request.UserRequest;
import ru.itis.agona.dto.response.EatenFoodResponse;
import ru.itis.agona.dto.response.UserResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {

    Set<UUID> save(List<UserRequest> userRequests);

    UserResponse getById(UUID id);

    Set<UserResponse> getAll();

    Set<EatenFoodResponse> getEatenFoodsById(UUID id);

    void deleteById(UUID id);

    void putById(UUID id, UserRequest userRequest);

    Set<UserResponse> getAll(int pageNumber, int pageSize, String direction, String name);

}
