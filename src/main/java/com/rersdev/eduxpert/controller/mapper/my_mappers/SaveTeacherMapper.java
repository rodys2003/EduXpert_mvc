package com.rersdev.eduxpert.controller.mapper.my_mappers;

import com.rersdev.eduxpert.controller.dto.insert.NewTeacher;
import com.rersdev.eduxpert.persistence.entity.Teacher;

public interface SaveTeacherMapper {

    Teacher ToEntity(NewTeacher teacher);
}
