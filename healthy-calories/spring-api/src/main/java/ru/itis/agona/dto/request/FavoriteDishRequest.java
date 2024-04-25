package ru.itis.agona.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Модель для создания Favorite-Dish-request")
public record FavoriteDishRequest(@ApiModelProperty(value = "Id пользователя")UUID id,
                                  @ApiModelProperty(value = "Количество съеденного") Short timesEaten,
                                  @ApiModelProperty(value = "Средний вес") Short averageWeight) {
}
