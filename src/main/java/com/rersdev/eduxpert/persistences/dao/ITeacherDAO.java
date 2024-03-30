package com.rersdev.eduxpert.persistences.dao;

import com.rersdev.eduxpert.persistences.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ITeacherDAO {

    Page<Teacher> findAll(Pageable pageable);

    Optional<Teacher> findById(UUID id);

    void save(Teacher teacher);
}
