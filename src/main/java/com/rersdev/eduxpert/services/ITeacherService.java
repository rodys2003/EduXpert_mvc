package com.rersdev.eduxpert.services;

import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherPartialInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherPartialUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ITeacherService {

    Page<TeacherInfoDto> findAll(String status, boolean isActive, Pageable pageable);

    Optional<TeacherPartialInfoDto> findById(UUID id);

    void save(TeacherDto teacher);

    TeacherPartialInfoDto partialUpdate(UUID id, TeacherPartialUpdateDto teacherPartialUpdateDto);

    void deleteByAdmin(UUID id);
}
