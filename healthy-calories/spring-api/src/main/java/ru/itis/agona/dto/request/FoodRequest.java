package ru.itis.agona.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "������ ��� �������� Food-request")
public record FoodRequest(@ApiModelProperty(value = "��������") String name,
                          @ApiModelProperty(value = "���������� ������ � 100 �������") Short proteins,
                          @ApiModelProperty(value = "���������� ����� � 100 �������") Short fats,
                          @ApiModelProperty(value = "���������� ��������� � 100 �������") Short carbohydrates,
                          @ApiModelProperty(value = "���������� ������� � 100 �������") Short caloriesNumber,
                          @ApiModelProperty(value = "��� �������") Short typeOfFood,
                          @ApiModelProperty(value = "Id ���������") UUID categoryId) {
}
