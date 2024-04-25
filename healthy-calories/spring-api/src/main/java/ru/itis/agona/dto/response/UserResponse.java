package ru.itis.agona.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Модель для создания User-response")
public record UserResponse(@ApiModelProperty(value = "Id") UUID id,
                           @ApiModelProperty(value = "Имя") String name,
                           @ApiModelProperty(value = "Фамилия") String surname,
                           @ApiModelProperty(value = "Возраст") Short age,
                           @ApiModelProperty(value = "Вес") Short weight,
                           @ApiModelProperty(value = "Рост") Short height,
                           @ApiModelProperty(value = "Тип питания") Short typeOfFood) {
}
