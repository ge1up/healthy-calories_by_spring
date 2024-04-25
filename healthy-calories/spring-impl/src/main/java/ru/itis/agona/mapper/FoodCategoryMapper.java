package ru.itis.agona.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.agona.dto.request.FoodCategoryRequest;
import ru.itis.agona.dto.response.FoodCategoryResponse;
import ru.itis.agona.model.FoodCategoryEntity;

@Mapper(componentModel = "spring")
public interface FoodCategoryMapper {

    @Mapping(target = "id", ignore = true)
    FoodCategoryEntity toEntity(FoodCategoryRequest foodCategoryRequest);

    FoodCategoryResponse toResponse(FoodCategoryEntity foodCategoryEntity);

}
