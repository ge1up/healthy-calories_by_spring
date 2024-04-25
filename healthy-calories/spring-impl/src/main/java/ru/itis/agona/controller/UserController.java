package ru.itis.agona.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.agona.api.UserApi;
import ru.itis.agona.dto.request.UserRequest;
import ru.itis.agona.dto.response.EatenFoodResponse;
import ru.itis.agona.dto.response.UserResponse;
import ru.itis.agona.service.user.UserService;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService service;

    @Override
    public Set<UUID> save(List<UserRequest> userRequests) {
        return service.save(userRequests);
    }

    @Override
    public UserResponse getById(UUID id) {
        return service.getById(id);
    }

    @Override
    public Set<EatenFoodResponse> getEatenFoodsById(UUID id) {
        return service.getEatenFoodsById(id);
    }

    @Override
    public Set<UserResponse> getAll() {
        return service.getAll();
    }

    @Override
    public Set<UserResponse> getAll(int pageNumber, int pageSize, String direction, String name) {
        return service.getAll(pageNumber, pageSize, direction, name);
    }

    @Override
    public void deleteById(UUID id) {
        service.deleteById(id);
    }

    @Override
    public void putById(UUID id, UserRequest userRequest) {
        service.putById(id, userRequest);
    }
}
