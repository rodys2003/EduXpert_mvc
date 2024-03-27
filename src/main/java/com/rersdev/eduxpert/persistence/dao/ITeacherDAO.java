package com.rersdev.eduxpert.persistence.dao;

import com.rersdev.eduxpert.persistence.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeacherDAO {

    Page<Teacher> findAll(Pageable pageable);

    void save(Teacher teacher);
}
