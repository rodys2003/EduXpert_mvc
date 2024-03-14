package com.rersdev.eduxpert.service;

import com.rersdev.eduxpert.persistence.entity.Teacher;

import java.util.List;
import java.util.UUID;

public interface ITeacherService {

    List<Teacher> findAll();

    Teacher findById(UUID id);

    Teacher save(Teacher teacher);
}
