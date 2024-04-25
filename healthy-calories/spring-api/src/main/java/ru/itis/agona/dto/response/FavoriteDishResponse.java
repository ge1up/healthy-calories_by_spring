package ru.itis.agona.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Модель для создания Favorite-Dish-response")
public record FavoriteDishResponse(@ApiModelProperty(value = "Id") UUID id,
                                   @ApiModelProperty(value = "Id пользователя") UUID userId,
                                   @ApiModelProperty(value = "Количество съеденного") Short timesEaten,
                                   @ApiModelProperty(value = "Средний вес") Short averageWeight) {
}
