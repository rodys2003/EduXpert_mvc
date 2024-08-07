package com.rersdev.eduxpert.services.impl;

import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherDto;
import com.rersdev.eduxpert.controllers.mappers.TeacherMapper;
import com.rersdev.eduxpert.persistences.entities.enums.TeacherStatus;
import com.rersdev.eduxpert.persistences.repositories.TeacherRepository;
import com.rersdev.eduxpert.services.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    @Override
    public void save(TeacherDto teacherDto) {
        this.teacherRepository.save(teacherMapper.toEntity(teacherDto));
    }

    @Override
    public Page<TeacherInfoDto> findAll(Pageable pageable) {
        List<TeacherInfoDto> teacherDtoList = teacherRepository.findAllByStatus(TeacherStatus.ACTIVO, pageable).stream()
                .map(teacherMapper::toGetDTO)
                .toList();
        return new PageImpl<>(teacherDtoList);
    }

    @Override
    public Optional<TeacherInfoDto> findById(UUID id) {
        return teacherRepository.findById(id).map(teacherMapper::toGetDTO);
    }
}
