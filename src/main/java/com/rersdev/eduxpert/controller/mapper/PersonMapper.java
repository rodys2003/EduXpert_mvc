package com.rersdev.eduxpert.controller.mapper;

import com.rersdev.eduxpert.controller.dto.GetPerson;
import com.rersdev.eduxpert.controller.dto.NewPerson;
import com.rersdev.eduxpert.persistence.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {

    GetPerson toGetDTO(Person person);


    Person toEntity(NewPerson person);
}
