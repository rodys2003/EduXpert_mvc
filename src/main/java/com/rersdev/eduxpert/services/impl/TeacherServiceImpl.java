package com.rersdev.eduxpert.services.impl;

import com.rersdev.eduxpert.config.advice.user.InvalidStatusException;
import com.rersdev.eduxpert.config.advice.user.UserAlreadyExistException;
import com.rersdev.eduxpert.config.advice.user.UserNotFoundException;
import com.rersdev.eduxpert.controllers.dto.users.teacher.*;
import com.rersdev.eduxpert.controllers.mappers.TeacherMapper;
import com.rersdev.eduxpert.persistences.entities.Teacher;
import com.rersdev.eduxpert.persistences.entities.auth.User;
import com.rersdev.eduxpert.persistences.entities.enums.TeacherStatus;
import com.rersdev.eduxpert.persistences.repositories.TeacherRepository;
import com.rersdev.eduxpert.services.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

@Transactional
@Service
public class TeacherServiceImpl implements ITeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    @Override
    public UUID save(TeacherDto teacherDto) {
        String documentNumber = teacherDto.person().user().documentNumber();
        if (teacherRepository.existsTeacherByDocumentNumber(documentNumber)) {
            throw new UserAlreadyExistException("Ya existe un usuario con el numero de documento: " + documentNumber);
        }
        Teacher teacher = this.teacherRepository.save(teacherMapper.toEntity(teacherDto));
        return teacher.getId();
    }

    @Override
    public TeacherPartialInfoDto partialUpdate(UUID id, TeacherPartialUpdateDto teacherPartialUpdateDto) {
        Teacher teacherFromDb = this.findTeacherByIdOrThrow(id);

        teacherMapper.toEntity(teacherFromDb, teacherPartialUpdateDto);
        return teacherMapper.toDto(teacherRepository.save(teacherFromDb));
    }

    @Override
    public TeacherInfoDto updateByAdmin(UUID id, TeacherUpdateDto teacherDto) {
        Teacher teacherFromDB = this.findTeacherByIdOrThrow(id);

        teacherMapper.toEntity(teacherFromDB, teacherDto);
        return teacherMapper.toDTO(teacherRepository.save(teacherFromDB));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<TeacherInfoDto> findAll(String status, boolean isActive, Pageable pageable) {
        if (status == null) {
            status = "ACTIVO";
        }
        String validStatus = this.validateStatus(status);
        return teacherRepository.findAllByStatusAndUserIsActive(TeacherStatus.valueOf(validStatus), isActive, pageable)
                .map(teacherMapper::toDTO);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TeacherPartialInfoDto> findById(UUID id) {
        return teacherRepository.findById(id).map(teacherMapper::toDto);
    }

    @Override
    public void updateStatus(String status, UUID id) {
        String validStatus = this.validateStatus(status);

        Teacher teacherFromDb = this.findTeacherByIdOrThrow(id);

        User user = teacherFromDb.getPerson().getUser();

        String statusDb = teacherFromDb.getStatus().toString();
        if ("ACTIVO".equals(validStatus)  && "RETIRADO".equals(statusDb) || "LICENCIA".equals(validStatus) && "RETIRADO".equals(statusDb)) {
            user.setIsActive(true);
        } else if ("RETIRADO".equals(validStatus)) {
            user.setIsActive(false);
        }

        teacherFromDb.setStatus(TeacherStatus.valueOf(validStatus));
        teacherRepository.save(teacherFromDb);
    }

    @Override
    public void deleteByAdmin(UUID id) {
        if (!teacherRepository.existsById(id)) {
            throw new UserNotFoundException("No se ha encontrado el profesor con id " + id);
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

    private String validateStatus(String status) {
        if (!isValidStatus(status)) {
            throw new InvalidStatusException(status + " => no es un estado valido");
        }
        return status.toUpperCase();
    }

    private Teacher findTeacherByIdOrThrow(UUID id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se ha encontrado el profesor con id: " + id));
    }
}