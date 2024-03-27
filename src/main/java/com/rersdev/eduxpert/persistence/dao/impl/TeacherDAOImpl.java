package com.rersdev.eduxpert.persistence.dao.impl;

import com.rersdev.eduxpert.persistence.dao.ITeacherDAO;
import com.rersdev.eduxpert.persistence.entity.Teacher;
import com.rersdev.eduxpert.persistence.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class TeacherDAOImpl implements ITeacherDAO {

    private final TeacherRepository teacherRepository;

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return this.teacherRepository.findAll(pageable);
    }

    @Override
    public void save(Teacher teacher) {
       this.teacherRepository.save(teacher);
    }
}
