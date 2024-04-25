package ru.itis.agona.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.agona.dto.request.FavoriteDishRequest;
import ru.itis.agona.dto.response.FavoriteDishResponse;
import ru.itis.agona.model.FavoriteDishEntity;

@Mapper(componentModel = "spring")
public interface FavoriteDishMapper {

    @Mapping(target = "id", ignore = true)
    FavoriteDishEntity toEntity(FavoriteDishRequest favoriteDishRequest);

    FavoriteDishResponse toResponse(FavoriteDishEntity favoriteDishEntity);

}
