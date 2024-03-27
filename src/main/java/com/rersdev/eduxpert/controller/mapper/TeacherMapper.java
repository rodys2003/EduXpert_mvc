package com.rersdev.eduxpert.controller.mapper;

import com.rersdev.eduxpert.controller.dto.get.GetTeacher;
import com.rersdev.eduxpert.persistence.entity.Teacher;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {PersonMapper.class})
public interface TeacherMapper {

    GetTeacher toGetDTO(Teacher teacher);
}
