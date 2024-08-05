package com.rersdev.eduxpert.persistences.repositories;

import com.rersdev.eduxpert.persistences.entities.Teacher;
import com.rersdev.eduxpert.persistences.entities.enums.TeacherStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

    Page<Teacher> findAllByStatus(TeacherStatus status, Pageable pageable);
}
