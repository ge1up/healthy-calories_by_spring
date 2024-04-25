package ru.itis.agona.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.agona.dto.request.EatenFoodRequest;
import ru.itis.agona.dto.response.EatenFoodResponse;
import ru.itis.agona.model.EatenFoodEntity;

@Mapper(componentModel = "spring")
public interface EatenFoodMapper {

    @Mapping(target = "id", ignore = true)
    EatenFoodEntity toEntity(EatenFoodRequest eatenFoodRequest);

    EatenFoodResponse toResponse(EatenFoodEntity eatenFoodEntity);

}
