package ru.itis.agona.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.agona.dto.request.UserRequest;
import ru.itis.agona.dto.response.EatenFoodResponse;
import ru.itis.agona.dto.response.UserResponse;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Api(tags = "Users | Пользователи", value = "Пользователь")
@RequestMapping("/api/v1/users")
public interface UserApi {

    @ApiOperation(value = "Создание списка пользователей", nickname = "users-create", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Пользователи созданы", response = Set.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Set<UUID> save(@RequestBody List<UserRequest> userRequests);

    @ApiOperation(value = "Получение пользователя по Id", nickname = "user-find-by-id", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь найден", response = UserResponse.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Пользователь с данным Id не найден"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    UserResponse getById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Получение съеденных продуктов по Id", nickname = "user-find-foods-by-id", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Съеденные пользователем продукты получены", response = Set.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{id}/foods")
    @ResponseStatus(HttpStatus.OK)
    Set<EatenFoodResponse> getEatenFoodsById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Получение набора всех пользователей", nickname = "users-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Набор пользователей успешно предоставлен", response = Set.class),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Set<UserResponse> getAll();

    @ApiOperation(value = "Получение набора страницы пользователей", nickname = "users-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Страница пользователей успешно предоставлена", response = Set.class),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{pageNumber}/{pageSize}/{direction}/{name}")
    @ResponseStatus(HttpStatus.OK)
    Set<UserResponse> getAll(@PathVariable("pageNumber") int pageNumber,
                             @PathVariable("pageSize") int pageSize,
                             @PathVariable("direction") String direction,
                             @PathVariable("name") String name);

    @ApiOperation(value = "Удаление пользователя по Id", nickname = "user-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Пользователь успешно удален", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Пользователь с данным Id не найден"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") UUID uuid);



    @ApiOperation(value = "Полное обновление пользователя по Id", nickname = "user-put-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Пользователь успешно обновлен", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Пользователь с данным Id не найден"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void putById(@PathVariable("id") UUID uuid, @RequestBody UserRequest userRequest);
}
