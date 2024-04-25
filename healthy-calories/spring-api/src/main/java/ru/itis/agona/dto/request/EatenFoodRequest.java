package ru.itis.agona.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "������ ��� �������� Eaten-Food-request")
public record EatenFoodRequest(@ApiModelProperty(value = "Id ������������")UUID userId,
                               @ApiModelProperty(value = "Id �������� �������") UUID foodId,
                               @ApiModelProperty(value = "���") Short weight) {
}
