package com.rersdev.eduxpert.controllers.mappers.my_mappers;

import com.rersdev.eduxpert.controllers.dto.insert.NewUser;
import com.rersdev.eduxpert.persistences.entities.auth.User;

public interface SaveUserMapper {

    User toEntity(NewUser user);
}
