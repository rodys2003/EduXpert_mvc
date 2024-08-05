package com.rersdev.eduxpert.controllers.mappers;

import com.rersdev.eduxpert.controllers.dto.get.GetTeacher;
import com.rersdev.eduxpert.controllers.dto.insert.NewTeacher;
import com.rersdev.eduxpert.persistences.entities.Teacher;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PersonMapper.class})
public interface TeacherMapper {

    GetTeacher toGetDTO(Teacher teacher);

    Teacher toEntity(NewTeacher newTeacher);
}
