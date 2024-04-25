package ru.itis.agona.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "������ ��� �������� Favorite-Dish-response")
public record FavoriteDishResponse(@ApiModelProperty(value = "Id") UUID id,
                                   @ApiModelProperty(value = "Id ������������") UUID userId,
                                   @ApiModelProperty(value = "���������� ����������") Short timesEaten,
                                   @ApiModelProperty(value = "������� ���") Short averageWeight) {
}
