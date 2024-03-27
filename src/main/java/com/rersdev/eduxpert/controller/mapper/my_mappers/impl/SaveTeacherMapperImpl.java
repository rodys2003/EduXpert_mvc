package com.rersdev.eduxpert.controller.mapper.my_mappers.impl;

import com.rersdev.eduxpert.controller.dto.insert.NewTeacher;
import com.rersdev.eduxpert.controller.mapper.my_mappers.SavePersonMapper;
import com.rersdev.eduxpert.controller.mapper.my_mappers.SaveTeacherMapper;
import com.rersdev.eduxpert.persistence.entity.Teacher;
import com.rersdev.eduxpert.persistence.entity.enums.TeacherStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class SaveTeacherMapperImpl implements SaveTeacherMapper {

    private final SavePersonMapper personMapper;

    @Override
    public Teacher ToEntity(NewTeacher teacher) {

        if (teacher == null) {
            return null;
        }

        return Teacher.builder()
                .specialization(teacher.getSpecialization())
                .dateStart(teacher.getDateStart())
                .status(TeacherStatus.ACTIVO)
                .person(personMapper.toEntity(teacher.getPerson()))
                .build();
    }
}
