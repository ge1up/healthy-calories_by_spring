package ru.itis.agona.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.agona.dto.request.FoodRequest;
import ru.itis.agona.dto.request.FoodResponse;
import ru.itis.agona.model.FoodEntity;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    @Mapping(target = "id", ignore = true)
    FoodEntity toEntity(FoodRequest foodRequest);

    FoodResponse toResponse(FoodEntity foodEntity);

}
