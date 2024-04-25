package ru.itis.agona.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.itis.agona.dto.request.FoodCategoryRequest;
import ru.itis.agona.dto.response.FoodCategoryResponse;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Api(tags = "Food Categories | Категории продуктов питания", value = "Категория продуктов питания")
@RequestMapping("/api/v1/food-categories")
public interface FoodCategoryApi {

    @ApiOperation(value = "Создание списка категорий продуктов питания", nickname = "food-categories-create", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Категории продуктов питания созданы", response = Set.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Set<UUID> save(@RequestBody List<FoodCategoryRequest> foodCategoryRequests);

    @ApiOperation(value = "Получение категории продукта питания по Id", nickname = "food-category-find-by-id", response = FoodCategoryResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Категория продукта питания найдена", response = FoodCategoryResponse.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Категория продукта питания с данным Id не найдена"),
            @ApiResponse(code = 500, message = "Серверная ошибка")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FoodCategoryResponse getById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Получение набора всех категорий продуктов питания", nickname = "food-categories-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Набор категорий продуктов питания успешно предоставлен", response = Set.class),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code= 500, message = "Серверная ошибка")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Set<FoodCategoryResponse> getAll();

    @ApiOperation(value = "Удаление категории продукта питания по Id", nickname = "food-category-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Категория продукта питания успешно удалена", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Категория продукта питания с данным Id не найдена"),
            @ApiResponse(code= 500, message = "Серверная ошибка")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "Полное обновление категории продукта питания по Id", nickname = "food-category-put-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Категория продукта питания успешно обновлена", response = Void.class),
            @ApiResponse(code = 400, message = "Ошибка валидации"),
            @ApiResponse(code = 403, message = "Недостаточно прав пользвателя"),
            @ApiResponse(code = 404, message = "Категория продукта питания с данным Id не найдена"),
            @ApiResponse(code= 500, message = "Серверная ошибка")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void putById(@PathVariable("id") UUID uuid, @RequestBody FoodCategoryRequest foodCategoryRequest);
}
