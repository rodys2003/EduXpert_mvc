package com.rersdev.eduxpert.services.impl;

import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherPartialInfoDto;
import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherPartialUpdateDto;
import com.rersdev.eduxpert.controllers.mappers.TeacherMapper;
import com.rersdev.eduxpert.persistences.entities.Teacher;
import com.rersdev.eduxpert.persistences.entities.auth.User;
import com.rersdev.eduxpert.persistences.entities.enums.TeacherStatus;
import com.rersdev.eduxpert.persistences.repositories.TeacherRepository;
import com.rersdev.eduxpert.services.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    @Override
    public UUID save(TeacherDto teacherDto) {
        String documentNumber = teacherDto.person().user().documentNumber();
        if (teacherRepository.existsTeacherByDocumentNumber(documentNumber)) {
            throw new RuntimeException("A user with that document number already exists");
        }
        Teacher teacher = this.teacherRepository.save(teacherMapper.toEntity(teacherDto));
        return teacher.getId();
    }

    @Override
    public TeacherPartialInfoDto partialUpdate(UUID id, TeacherPartialUpdateDto teacherPartialUpdateDto) {
        Teacher teacherFromDb = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        teacherMapper.toEntity(teacherFromDb, teacherPartialUpdateDto);
        return teacherMapper.toDto(teacherRepository.save(teacherFromDb));
    }

    @Override
    public Page<TeacherInfoDto> findAll(String status, boolean isActive, Pageable pageable) {
        if (status == null) {
            status = "ACTIVO";
        }
        this.validateStatus(status);
        List<TeacherInfoDto> teacherDtoList = teacherRepository.findAllByStatusAndUserIsActive(TeacherStatus.valueOf(status.toUpperCase()), isActive, pageable).stream()
                .map(teacherMapper::toDTO)
                .toList();
        return new PageImpl<>(teacherDtoList);
    }

    @Override
    public Optional<TeacherPartialInfoDto> findById(UUID id) {
        return teacherRepository.findById(id).map(teacherMapper::toDto);
    }

    @Override
    public void updateStatus(String status, UUID id) {
        this.validateStatus(status);

        Teacher teacherFromDB = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacherFromDB.setStatus(TeacherStatus.valueOf(status.toUpperCase()));

        if (status.equalsIgnoreCase("RETIRADO")) {
            User u = teacherFromDB.getPerson().getUser();
            u.setIsActive(false);
            teacherRepository.save(teacherFromDB);
        }

        teacherRepository.save(teacherFromDB);
    }

    @Override
    public void deleteByAdmin(UUID id) {
        if (!teacherRepository.existsById(id)) {
            throw new RuntimeException("Teacher not found");
        }
        teacherRepository.deleteById(id);
    }

    private boolean isValidStatus(String status) {
        for (TeacherStatus teacherStatus : TeacherStatus.values()) {
            if (teacherStatus.name().equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }

    private void validateStatus(String status) {
        if (!isValidStatus(status)) {
            throw new RuntimeException("invalid status: " + status);
        }
    }
}
