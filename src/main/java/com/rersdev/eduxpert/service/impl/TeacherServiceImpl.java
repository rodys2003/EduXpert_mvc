package com.rersdev.eduxpert.service.impl;

import com.rersdev.eduxpert.controller.dto.get.GetTeacher;
import com.rersdev.eduxpert.controller.dto.insert.NewTeacher;
import com.rersdev.eduxpert.controller.mapper.TeacherMapper;
import com.rersdev.eduxpert.controller.mapper.my_mappers.SaveTeacherMapper;
import com.rersdev.eduxpert.persistence.dao.ITeacherDAO;
import com.rersdev.eduxpert.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final ITeacherDAO teacherDAO;

    private final SaveTeacherMapper saveTeacherMapper;

    @Override
    public void save(NewTeacher teacherDto) {
        if (teacherDto.getDateStart() == null) {
            teacherDto.setDateStart(LocalDate.now());
        }
        this.teacherDAO.save(saveTeacherMapper.ToEntity(teacherDto));
    }

    private final TeacherMapper teacherMapper;

    @Override
    public Page<GetTeacher> findAll(Pageable pageable) {
        List<GetTeacher> teacherDtoList = teacherDAO.findAll(pageable).stream()
                .map(teacherMapper::toGetDTO)
                .toList();
        return new PageImpl<>(teacherDtoList);
    }
}
