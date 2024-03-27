package com.rersdev.eduxpert.controller.mapper.my_mappers.impl;

import com.rersdev.eduxpert.controller.dto.insert.NewPerson;
import com.rersdev.eduxpert.controller.mapper.my_mappers.SavePersonMapper;
import com.rersdev.eduxpert.controller.mapper.my_mappers.SaveUserMapper;
import com.rersdev.eduxpert.persistence.entity.Person;
import com.rersdev.eduxpert.persistence.entity.enums.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor

@Component
public class SavePersonMapperImpl implements SavePersonMapper {

    private final SaveUserMapper userMapper;

    @Override
    public Person toEntity(NewPerson person) {

        if (person == null) {
            return null;
        }

        return Person.builder()
                .user(userMapper.toEntity(person.getUser()))
                .documentType(person.getDocumentType())
                .name(person.getName())
                .lastName(person.getLastName())
                .dateBirth(person.getDateBirth())
                .gender(Enum.valueOf(Gender.class, person.getGender()))
                .address(person.getAddress())
                .email(person.getEmail())
                .phoneNumber(person.getPhoneNumber())
                .dateCreated(LocalDateTime.now())
                .build();
    }
}
