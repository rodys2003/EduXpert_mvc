package com.rersdev.eduxpert.controllers.mappers;

import com.rersdev.eduxpert.controllers.dto.users.UserInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.UserDto;
import com.rersdev.eduxpert.persistences.entities.auth.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserInfoDto toDTO(User user);

    User toEntity(UserDto userDto);
}
