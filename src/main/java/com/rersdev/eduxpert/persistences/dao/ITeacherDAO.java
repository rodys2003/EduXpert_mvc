package com.rersdev.eduxpert.persistences.dao;

import com.rersdev.eduxpert.persistences.entities.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeacherDAO {

    Page<Teacher> findAll(Pageable pageable);

    void save(Teacher teacher);
}
