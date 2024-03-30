package com.rersdev.eduxpert.controllers.mappers;

import com.rersdev.eduxpert.controllers.dto.get.GetUser;
import com.rersdev.eduxpert.persistences.entities.auth.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    GetUser toDTO(User user);

    List<GetUser> toDTOList(List<User> users);
}
