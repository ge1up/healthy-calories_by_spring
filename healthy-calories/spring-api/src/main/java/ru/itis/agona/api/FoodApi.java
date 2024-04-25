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

@Api(tags = "Foods | �������� �������", value = "������� �������")
@RequestMapping("/api/v1/foods")
public interface FoodApi {

    @ApiOperation(value = "�������� ������ ��������� �������", nickname = "foods-create", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "�������� ������� �������", response = Set.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 500, message = "��������� ������")
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Set<UUID> save(@RequestBody List<FoodRequest> foodRequests);

    @ApiOperation(value = "��������� �������� ������� �� Id", nickname = "food-find-by-id", response = FoodResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "������� ������� ������", response = FoodResponse.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 404, message = "������� ������� � ������ Id �� ������"),
            @ApiResponse(code = 500, message = "��������� ������")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    FoodResponse getById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "��������� ������ ���� ��������� �������", nickname = "foods-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "����� ��������� ������� ������� ������������", response = Set.class),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code= 500, message = "��������� ������")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Set<FoodResponse> getAll();

    @ApiOperation(value = "�������� �������� ������� �� Id", nickname = "food-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "������� ������� ������� ������", response = Void.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 404, message = "������� ������� � ������ Id �� ������"),
            @ApiResponse(code= 500, message = "��������� ������")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "������ ���������� �������� ������� �� Id", nickname = "food-put-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "������� ������� ������� ��������", response = Void.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 404, message = "������� ������� � ������ Id �� ������"),
            @ApiResponse(code= 500, message = "��������� ������")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void putById(@PathVariable("id") UUID uuid, @RequestBody FoodRequest foodRequest);
}
