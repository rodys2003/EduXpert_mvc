package com.rersdev.eduxpert.controllers.mappers.my_mappers;

import com.rersdev.eduxpert.controllers.dto.insert.NewTeacher;
import com.rersdev.eduxpert.persistences.entities.Teacher;

public interface SaveTeacherMapper {

    Teacher ToEntity(NewTeacher teacher);
}
