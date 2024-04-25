package ru.itis.agona.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "������ ��� �������� Favorite-Dish-request")
public record FavoriteDishRequest(@ApiModelProperty(value = "Id ������������")UUID id,
                                  @ApiModelProperty(value = "���������� ����������") Short timesEaten,
                                  @ApiModelProperty(value = "������� ���") Short averageWeight) {
}
