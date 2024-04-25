package ru.itis.agona.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Модель для создания Food-Category-Response")
public record FoodCategoryResponse(@ApiModelProperty(value = "Id")UUID id,
                                   @ApiModelProperty(value = "Название") String name) {
}
