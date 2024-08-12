package com.rersdev.eduxpert.mappers;

import com.rersdev.eduxpert.dto.users.teacher.*;
import com.rersdev.eduxpert.persistences.entities.Teacher;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PersonMapper.class})
public interface TeacherMapper {

    TeacherInfoDto toDTO(Teacher teacher);

    TeacherPartialInfoDto toDto(Teacher teacher);

    Teacher toEntity(TeacherDto teacherDto);

    void toEntity(@MappingTarget Teacher teacher, TeacherPartialUpdateDto teacherPartialUpdateDto);

    void  toEntity(@MappingTarget Teacher teacher, TeacherUpdateDto teacherUpdateDto);
}
