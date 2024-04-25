package ru.itis.agona.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.agona.dto.request.EatenFoodRequest;
import ru.itis.agona.dto.response.EatenFoodResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Api(tags = "Eaten Foods | Съеденные продукты", value = "Съеденный продукт")
@RequestMapping("/api/v1/eaten-foods")
public interface EatenFoodApi {

    @ApiOperation(value = "Создание списка съеденных продуктов", nickname = "eaten-foods-create", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Список съеденных продуктов создан", response = Set.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Set<UUID> save(@RequestBody List<EatenFoodRequest> eatenFoodRequests);

    @ApiOperation(value = "Получение съеденного продукта по Id", nickname = "eaten-food-find-by-id", response = EatenFoodResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Съеденный продукт найден", response = EatenFoodResponse.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Съеденный продукт с данным Id не найден"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    EatenFoodResponse getById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Получение набора всех съеденных продуктов", nickname = "eaten-foods-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Набор съеденных продуктов успешно предоставлен", response = Set.class),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Set<EatenFoodResponse> getAll();

    @ApiOperation(value = "Удаление съеденного продукта по Id", nickname = "eaten-food-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Съеденный продукт успешно удален", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Съеденный продукт с данным Id не найден"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Полное обновление съеденного продукта по Id", nickname = "eaten-food-put-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Съеденный продукт успешно обновлен", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Съеденный продукт не найден"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void putById(@PathVariable("id") UUID uuid, @RequestBody EatenFoodRequest eatenFoodRequest);
}
