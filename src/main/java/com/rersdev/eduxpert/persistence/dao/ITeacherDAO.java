package com.rersdev.eduxpert.persistence.dao;

import com.rersdev.eduxpert.persistence.entity.Teacher;

import java.util.List;
import java.util.UUID;

public interface ITeacherDAO {

    List<Teacher> findAll();

    Teacher findById(UUID id);

    Teacher save(Teacher teacher);
}
