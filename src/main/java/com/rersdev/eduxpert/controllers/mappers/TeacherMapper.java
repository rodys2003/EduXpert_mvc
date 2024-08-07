package com.rersdev.eduxpert.controllers.mappers;

import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherDto;
import com.rersdev.eduxpert.persistences.entities.Teacher;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PersonMapper.class})
public interface TeacherMapper {

    TeacherInfoDto toGetDTO(Teacher teacher);

    Teacher toEntity(TeacherDto teacherDto);
}
