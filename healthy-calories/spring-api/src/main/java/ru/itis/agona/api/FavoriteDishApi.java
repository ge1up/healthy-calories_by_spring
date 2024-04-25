package ru.itis.agona.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.agona.dto.request.FavoriteDishRequest;
import ru.itis.agona.dto.response.FavoriteDishResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Api(tags = "Favorite Dishes | Любимые блюда", value = "Любимое блюдо")
@RequestMapping("/api/v1/favorite-dishes")
public interface FavoriteDishApi {

    @ApiOperation(value = "Создание списка любимых блюд", nickname = "favorite-dishes-create", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Любимые блюда созданы", response = Set.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Set<UUID> save(@RequestBody List<FavoriteDishRequest> favoriteDishRequests);

    @ApiOperation(value = "Получение любимого блюда по Id", nickname = "favorite-dish-find-by-id", response = FavoriteDishResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Любимое блюдо найдено", response = FavoriteDishResponse.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Любимое блюдо с данным Id не найдено"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FavoriteDishResponse getById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Получение набора всех любимых блюд", nickname = "favorite-dishes-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Набор любимых блюд успешно предоставлен", response = Set.class),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code= 500, message = "Серверная ошибка")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Set<FavoriteDishResponse> getAll();

    @ApiOperation(value = "Удаление любимого блюда по Id", nickname = "favorite-dish-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Любимое блюдо успешно удалено", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Любимое блюдо с данным Id не найдено"),
            @ApiResponse(code= 500, message = "Серверная ошибка")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Полное обновление любимого блюда по Id", nickname = "favorite-dish-put-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Любимое блюдо успешно обновлено", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Любимое блюдо с данным Id не найдено"),
            @ApiResponse(code= 500, message = "Серверная ошибка")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void putById(@PathVariable("id") UUID uuid, @RequestBody FavoriteDishRequest favoriteDishRequest);
}
