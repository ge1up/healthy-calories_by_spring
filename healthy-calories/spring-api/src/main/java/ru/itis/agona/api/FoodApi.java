package ru.itis.agona.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.agona.dto.request.FoodRequest;
import ru.itis.agona.dto.request.FoodResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Api(tags = "Foods | Продукты питания", value = "Продукт питания")
@RequestMapping("/api/v1/foods")
public interface FoodApi {

    @ApiOperation(value = "Создание списка продуктов питания", nickname = "foods-create", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Продукты питания созданы", response = Set.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Set<UUID> save(@RequestBody List<FoodRequest> foodRequests);

    @ApiOperation(value = "Получение продукта питания по Id", nickname = "food-find-by-id", response = FoodResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Продукт питания найден", response = FoodResponse.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Продукт питания с данным Id не найден"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FoodResponse getById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Получение набора всех продуктов питания", nickname = "foods-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Набор продуктов питания успешно предоставлен", response = Set.class),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code= 500, message = "Серверная ошибка")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Set<FoodResponse> getAll();

    @ApiOperation(value = "Удаление продукта питания по Id", nickname = "food-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Продукт питания успешно удален", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Продукт питания с данным Id не найден"),
            @ApiResponse(code= 500, message = "Серверная ошибка")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Полное обновление продукта питания по Id", nickname = "food-put-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Продукт питания успешно обновлен", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Продукт питания с данным Id не найден"),
            @ApiResponse(code= 500, message = "Серверная ошибка")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void putById(@PathVariable("id") UUID uuid, @RequestBody FoodRequest foodRequest);
}
