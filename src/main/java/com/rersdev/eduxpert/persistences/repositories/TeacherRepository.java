package com.rersdev.eduxpert.persistences.repositories;

import com.rersdev.eduxpert.persistences.entities.Teacher;
import com.rersdev.eduxpert.persistences.entities.enums.TeacherStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

    @Query("SELECT t FROM Teacher t WHERE t.status =?1 AND t.person.user.isActive =?2")
    Page<Teacher> findAllByStatusAndUserIsActive(TeacherStatus status, boolean isActive, Pageable pageable);

    @Query("SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END FROM Teacher t WHERE t.person.user.documentNumber =?1")
    boolean existsTeacherByDocumentNumber(String documentNumber);
}
