package ru.itis.agona.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@ApiModel(description = "������ ��� �������� Eaten-Food-response")
public record EatenFoodResponse(@ApiModelProperty(value = "Id") UUID id,
                                @ApiModelProperty(value = "Id ������������") UUID userId,
                                @ApiModelProperty(value = "Id �������� �������") UUID foodId,
                                @ApiModelProperty(value = "���") Short weight) {
}
