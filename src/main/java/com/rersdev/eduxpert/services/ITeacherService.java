package com.rersdev.eduxpert.services;

import com.rersdev.eduxpert.controllers.dto.get.GetTeacher;
import com.rersdev.eduxpert.controllers.dto.insert.NewTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ITeacherService {

    Page<GetTeacher> findAll(Pageable pageable);

    Optional<GetTeacher> findById(UUID id);

    void save(NewTeacher teacher);
}
