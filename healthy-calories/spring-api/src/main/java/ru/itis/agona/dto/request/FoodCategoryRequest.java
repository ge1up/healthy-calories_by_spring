package ru.itis.agona.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "������ ��� �������� Food-Category-request")
public record FoodCategoryRequest(@ApiModelProperty(value = "��������") String name) {
}
