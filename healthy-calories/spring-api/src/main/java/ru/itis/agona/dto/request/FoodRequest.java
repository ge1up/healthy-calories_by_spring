package ru.itis.agona.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Модель для создание Food-request")
public record FoodRequest(@ApiModelProperty(value = "Название") String name,
                          @ApiModelProperty(value = "Количество белков в 100 граммах") Short proteins,
                          @ApiModelProperty(value = "Количество жиров в 100 граммах") Short fats,
                          @ApiModelProperty(value = "Количество углеводов в 100 граммах") Short carbohydrates,
                          @ApiModelProperty(value = "Количество калорий в 100 граммах") Short caloriesNumber,
                          @ApiModelProperty(value = "Тип питания") Short typeOfFood,
                          @ApiModelProperty(value = "Id категории") UUID categoryId) {
}
