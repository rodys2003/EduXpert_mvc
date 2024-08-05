package com.rersdev.eduxpert.controllers.mappers;

import com.rersdev.eduxpert.controllers.dto.get.GetPerson;
import com.rersdev.eduxpert.controllers.dto.insert.NewPerson;
import com.rersdev.eduxpert.persistences.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserMapper.class})
public interface PersonMapper {

    GetPerson toGetDTO(Person person);

    Person toEntity(NewPerson newPerson);
}
