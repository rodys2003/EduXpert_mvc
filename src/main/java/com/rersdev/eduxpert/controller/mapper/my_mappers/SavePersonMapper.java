package com.rersdev.eduxpert.controller.mapper.my_mappers;

import com.rersdev.eduxpert.controller.dto.insert.NewPerson;
import com.rersdev.eduxpert.persistence.entity.Person;

public interface SavePersonMapper {

    Person toEntity(NewPerson person);
}
