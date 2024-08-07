package com.rersdev.eduxpert.controllers;

import com.rersdev.eduxpert.controllers.dto.users.teacher.TeacherDto;
import com.rersdev.eduxpert.services.ITeacherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@RequiredArgsConstructor

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final ITeacherService teacherService;

    @PostMapping
    public ResponseEntity<?> saveNewTeacher(@RequestBody TeacherDto teacherDto)
            throws URISyntaxException {
        teacherService.save(teacherDto);
        return ResponseEntity.created(new URI("/eduxpert/api/v1/endpoints/teachers")).build();
    }

    @GetMapping
    public ResponseEntity<?> getTeachers(
            @PageableDefault
            Pageable pageable){
        return ResponseEntity.ok().body(teacherService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable UUID id){
       return teacherService.findById(id).map(ResponseEntity::ok)
               .orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado"));
    }
}
