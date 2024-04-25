package ru.itis.agona.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для создания Food-Category-request")
public record FoodCategoryRequest(@ApiModelProperty(value = "Название") String name) {
}
