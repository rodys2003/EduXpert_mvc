package com.rersdev.eduxpert.controller.mapper.my_mappers;

import com.rersdev.eduxpert.controller.dto.insert.NewUser;
import com.rersdev.eduxpert.persistence.entity.auth.User;

public interface SaveUserMapper {

    User toEntity(NewUser user);
}
