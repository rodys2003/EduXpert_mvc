package com.rersdev.eduxpert.controllers.mappers;

import com.rersdev.eduxpert.controllers.dto.users.person.*;
import com.rersdev.eduxpert.persistences.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserMapper.class})
public interface PersonMapper {

    PersonInfoDto toDTO(Person person);

    PersonPartialInfoDto toDto(Person person);

    Person toEntity(PersonDto personDto);

    void toEntity(@MappingTarget Person person, PersonPartialUpdateDto personPartialUpdateDto);

    void toEntity(@MappingTarget Person person, PersonUpdateDto personUpdateDto);
}
