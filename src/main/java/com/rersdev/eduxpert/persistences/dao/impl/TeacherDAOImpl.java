package com.rersdev.eduxpert.persistences.dao.impl;

import com.rersdev.eduxpert.persistences.dao.ITeacherDAO;
import com.rersdev.eduxpert.persistences.entities.Teacher;
import com.rersdev.eduxpert.persistences.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

@Component
public class TeacherDAOImpl implements ITeacherDAO {

    private final TeacherRepository teacherRepository;

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return this.teacherRepository.findAll(pageable);
    }

    @Override
    public Optional<Teacher> findById(UUID id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void save(Teacher teacher) {
       this.teacherRepository.save(teacher);
    }
}
