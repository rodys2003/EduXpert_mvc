package com.rersdev.eduxpert.controllers.mappers;

import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherPartialInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherPartialUpdateDto;
import com.rersdev.eduxpert.persistences.entities.Teacher;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PersonMapper.class})
public interface TeacherMapper {

    TeacherInfoDto toDTO(Teacher teacher);

    TeacherPartialInfoDto toDto(Teacher teacher);

    Teacher toEntity(TeacherDto teacherDto);

    void toEntity(@MappingTarget Teacher teacher, TeacherPartialUpdateDto teacherPartialUpdateDto);
}
