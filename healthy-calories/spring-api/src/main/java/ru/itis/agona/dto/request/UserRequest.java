package ru.itis.agona.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для создания User-request")
public record UserRequest(@ApiModelProperty(value = "Имя") String name,
                          @ApiModelProperty(value = "Фамилия") String surname,
                          @ApiModelProperty(value = "Возраст") Short age,
                          @ApiModelProperty(value = "Вес") Short weight,
                          @ApiModelProperty(value = "Рост") Short height,
                          @ApiModelProperty(value = "Тип питания") Short typeOfFood) {
}
