package ru.itis.agona.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@ApiModel(description = "Модель для создания Eaten-Food-response")
public record EatenFoodResponse(@ApiModelProperty(value = "Id") UUID id,
                                @ApiModelProperty(value = "Id пользователя") UUID userId,
                                @ApiModelProperty(value = "Id продукта питания") UUID foodId,
                                @ApiModelProperty(value = "Вес") Short weight) {
}
