package com.rersdev.eduxpert.services.impl;

import com.rersdev.eduxpert.controllers.dto.get.GetTeacher;
import com.rersdev.eduxpert.controllers.dto.insert.NewTeacher;
import com.rersdev.eduxpert.controllers.mappers.TeacherMapper;
import com.rersdev.eduxpert.controllers.mappers.my_mappers.SaveTeacherMapper;
import com.rersdev.eduxpert.persistences.repositories.TeacherRepository;
import com.rersdev.eduxpert.services.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final TeacherRepository teacherRepository;

    private final SaveTeacherMapper saveTeacherMapper;

    @Override
    public void save(NewTeacher teacherDto) {
        if (teacherDto.getDateStart() == null) {
            teacherDto.setDateStart(LocalDate.now());
        }
        this.teacherRepository.save(saveTeacherMapper.ToEntity(teacherDto));
    }

    private final TeacherMapper teacherMapper;

    @Override
    public Page<GetTeacher> findAll(Pageable pageable) {
        List<GetTeacher> teacherDtoList = teacherRepository.findAll(pageable).stream()
                .map(teacherMapper::toGetDTO)
                .toList();
        return new PageImpl<>(teacherDtoList);
    }

    @Override
    public Optional<GetTeacher> findById(UUID id) {
        return teacherRepository.findById(id).map(teacherMapper::toGetDTO);
    }
}
