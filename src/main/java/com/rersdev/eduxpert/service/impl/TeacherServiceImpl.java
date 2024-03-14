package com.rersdev.eduxpert.service.impl;

import com.rersdev.eduxpert.persistence.dao.ITeacherDAO;
import com.rersdev.eduxpert.persistence.entity.Teacher;
import com.rersdev.eduxpert.persistence.entity.auth.User;
import com.rersdev.eduxpert.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final ITeacherDAO teacherDAO;

    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    @Override
    public Teacher findById(UUID id) {
        return teacherDAO.findById(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherDAO.save(teacher);
    }
}
