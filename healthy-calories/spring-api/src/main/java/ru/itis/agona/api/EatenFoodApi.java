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

@Api(tags = "Eaten Foods | ��������� ��������", value = "��������� �������")
@RequestMapping("/api/v1/eaten-foods")
public interface EatenFoodApi {

    @ApiOperation(value = "�������� ������ ��������� ���������", nickname = "eaten-foods-create", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "������ ��������� ��������� ������", response = Set.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 500, message = "��������� ������")
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Set<UUID> save(@RequestBody List<EatenFoodRequest> eatenFoodRequests);

    @ApiOperation(value = "��������� ���������� �������� �� Id", nickname = "eaten-food-find-by-id", response = EatenFoodResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "��������� ������� ������", response = EatenFoodResponse.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 404, message = "��������� ������� � ������ Id �� ������"),
            @ApiResponse(code = 500, message = "��������� ������")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    EatenFoodResponse getById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "��������� ������ ���� ��������� ���������", nickname = "eaten-foods-get-all", response = Set.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "����� ��������� ��������� ������� ������������", response = Set.class),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 500, message = "��������� ������")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Set<EatenFoodResponse> getAll();

    @ApiOperation(value = "�������� ���������� �������� �� Id", nickname = "eaten-food-delete-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "��������� ������� ������� ������", response = Void.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 404, message = "��������� ������� � ������ Id �� ������"),
            @ApiResponse(code = 500, message = "��������� ������")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") UUID uuid);

    @ApiOperation(value = "������ ���������� ���������� �������� �� Id", nickname = "eaten-food-put-by-id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "��������� ������� ������� ��������", response = Void.class),
            @ApiResponse(code = 400, message = "������ ���������"),
            @ApiResponse(code = 403, message = "������������ ���� �����������"),
            @ApiResponse(code = 404, message = "��������� ������� �� ������"),
            @ApiResponse(code = 500, message = "��������� ������")
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void putById(@PathVariable("id") UUID uuid, @RequestBody EatenFoodRequest eatenFoodRequest);
}
