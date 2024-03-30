package com.rersdev.eduxpert.controllers.mappers.my_mappers;

import com.rersdev.eduxpert.controllers.dto.insert.NewPerson;
import com.rersdev.eduxpert.persistences.entities.Person;

public interface SavePersonMapper {

    Person toEntity(NewPerson person);
}
