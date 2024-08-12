package com.rersdev.eduxpert.services;

import com.rersdev.eduxpert.dto.users.teacher.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ITeacherService {

    Page<TeacherInfoDto> findAll(String status, boolean isActive, Pageable pageable);

    Optional<TeacherPartialInfoDto> findById(UUID id);

    UUID save(TeacherDto teacher);

    TeacherPartialInfoDto partialUpdate(UUID id, TeacherPartialUpdateDto teacherPartialUpdateDto);

    TeacherInfoDto updateByAdmin(UUID id, TeacherUpdateDto teacherUpdated);

    void deleteByAdmin(UUID id);

    void updateStatus(String status, UUID id);
}
