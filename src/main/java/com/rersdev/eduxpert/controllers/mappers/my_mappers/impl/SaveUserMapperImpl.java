package com.rersdev.eduxpert.controllers.mappers.my_mappers.impl;

import com.rersdev.eduxpert.controllers.dto.insert.NewUser;
import com.rersdev.eduxpert.controllers.mappers.my_mappers.SaveUserMapper;
import com.rersdev.eduxpert.persistences.entities.auth.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SaveUserMapperImpl implements SaveUserMapper {

    @Override
    public User toEntity(NewUser user) {

        if (user == null) {
            return null;
        }

        return User.builder()
                .documentNumber(user.getDocumentNumber())
                .password(user.getDocumentNumber())
                .isActive(true)
                .dateCreated(LocalDateTime.now())
                .build();
    }
}
