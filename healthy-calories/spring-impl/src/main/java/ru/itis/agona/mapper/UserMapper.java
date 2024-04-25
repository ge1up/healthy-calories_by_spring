package ru.itis.agona.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.agona.dto.request.UserRequest;
import ru.itis.agona.dto.response.UserResponse;
import ru.itis.agona.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserRequest userRequest);

    UserResponse toResponse(UserEntity userEntity);

}
