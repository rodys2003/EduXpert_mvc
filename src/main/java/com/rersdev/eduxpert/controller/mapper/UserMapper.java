package com.rersdev.eduxpert.controller.mapper;

import com.rersdev.eduxpert.controller.dto.get.GetUser;
import com.rersdev.eduxpert.controller.dto.insert.NewUser;
import com.rersdev.eduxpert.persistence.entity.auth.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User toEntity(NewUser user);

    GetUser toDTO(User user);

    List<GetUser> toDTOList(List<User> users);
}
