package com.rersdev.eduxpert.controller.mapper;

import com.rersdev.eduxpert.controller.dto.get.GetUser;
import com.rersdev.eduxpert.persistence.entity.auth.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    GetUser toDTO(User user);

    List<GetUser> toDTOList(List<User> users);
}
