package ru.itis.agona.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Модель для создания Eaten-Food-request")
public record EatenFoodRequest(@ApiModelProperty(value = "Id пользователя")UUID userId,
                               @ApiModelProperty(value = "Id продукта питания") UUID foodId,
                               @ApiModelProperty(value = "Вес") Short weight) {
}
