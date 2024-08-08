package com.rersdev.eduxpert.services.impl;

import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherPartialInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherPartialUpdateDto;
import com.rersdev.eduxpert.controllers.mappers.TeacherMapper;
import com.rersdev.eduxpert.persistences.entities.Teacher;
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
    public TeacherPartialInfoDto partialUpdate(UUID id, TeacherPartialUpdateDto teacherPartialUpdateDto) {
        Teacher teacherFromDb = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        teacherMapper.toEntity(teacherFromDb, teacherPartialUpdateDto);
        return teacherMapper.toDto(teacherRepository.save(teacherFromDb));
    }

    @Override
    public Page<TeacherInfoDto> findAll(Pageable pageable) {
        List<TeacherInfoDto> teacherDtoList = teacherRepository.findAllByStatus(TeacherStatus.ACTIVO, pageable).stream()
                .map(teacherMapper::toDTO)
                .toList();
        return new PageImpl<>(teacherDtoList);
    }

    @Override
    public Optional<TeacherPartialInfoDto> findById(UUID id) {
        return teacherRepository.findById(id).map(teacherMapper::toDto);
    }

    @Override
    public void deleteByAdmin(UUID id) {
        if (!teacherRepository.existsById(id)) {
            throw new RuntimeException("Teacher not found");
        }
        teacherRepository.deleteById(id);
    }
}
