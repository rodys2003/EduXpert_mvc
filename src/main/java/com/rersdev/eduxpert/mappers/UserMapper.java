package com.rersdev.eduxpert.mappers;

import com.rersdev.eduxpert.dto.users.UserInfoDto;
import com.rersdev.eduxpert.dto.users.UserDto;
import com.rersdev.eduxpert.dto.users.UserPartialInfoDto;
import com.rersdev.eduxpert.persistences.entities.auth.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserInfoDto toDTO(User user);

    UserPartialInfoDto toDto(User user);

    User toEntity(UserDto userDto);
}
