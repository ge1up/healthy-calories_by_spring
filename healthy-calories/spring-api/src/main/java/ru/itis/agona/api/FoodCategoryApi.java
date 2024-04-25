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

@Api(tags = "Food Categories | ��������� ��������� �������", value = "��������� ��������� �������")
@RequestMapping("/api/v1/food-categories")
public interface FoodCategoryApi {

    @ApiOperation(value = "�������� ������ ��������� ��������� �������", nickname = "food-categories-create", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "��������� ��������� ������� �������", response = Set.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 500, message = "��������� ������")
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Set<UUID> save(@RequestBody List<FoodCategoryRequest> foodCategoryRequests);

    @ApiOperation(value = "��������� ��������� �������� ������� �� Id", nickname = "food-category-find-by-id", response = FoodCategoryResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��������� �������� ������� �������", response = FoodCategoryResponse.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 404, message = "��������� �������� ������� � ������ Id �� �������"),
            @ApiResponse(code = 500, message = "��������� ������")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FoodCategoryResponse getById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "��������� ������ ���� ��������� ��������� �������", nickname = "food-categories-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "����� ��������� ��������� ������� ������� ������������", response = Set.class),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code= 500, message = "��������� ������")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Set<FoodCategoryResponse> getAll();

    @ApiOperation(value = "�������� ��������� �������� ������� �� Id", nickname = "food-category-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "��������� �������� ������� ������� �������", response = Void.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 404, message = "��������� �������� ������� � ������ Id �� �������"),
            @ApiResponse(code= 500, message = "��������� ������")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "������ ���������� ��������� �������� ������� �� Id", nickname = "food-category-put-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "��������� �������� ������� ������� ���������", response = Void.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 404, message = "��������� �������� ������� � ������ Id �� �������"),
            @ApiResponse(code= 500, message = "��������� ������")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void putById(@PathVariable("id") UUID uuid, @RequestBody FoodCategoryRequest foodCategoryRequest);
}
