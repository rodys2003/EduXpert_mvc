package com.rersdev.eduxpert.services;

import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ITeacherService {

    Page<TeacherInfoDto> findAll(Pageable pageable);

    Optional<TeacherInfoDto> findById(UUID id);

    void save(TeacherDto teacher);
}
