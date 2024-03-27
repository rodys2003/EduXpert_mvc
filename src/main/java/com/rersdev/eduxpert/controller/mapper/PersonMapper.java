package com.rersdev.eduxpert.controller.mapper;

import com.rersdev.eduxpert.controller.dto.get.GetPerson;
import com.rersdev.eduxpert.persistence.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserMapper.class})
public interface PersonMapper {

    GetPerson toGetDTO(Person person);
}
