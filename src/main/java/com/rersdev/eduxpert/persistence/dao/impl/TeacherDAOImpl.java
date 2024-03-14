package com.rersdev.eduxpert.persistence.dao.impl;

import com.rersdev.eduxpert.persistence.dao.ITeacherDAO;
import com.rersdev.eduxpert.persistence.entity.Teacher;
import com.rersdev.eduxpert.persistence.repository.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Component
public class TeacherDAOImpl implements ITeacherDAO {

    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(UUID id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("profesor no encontrado con id " + id));
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
