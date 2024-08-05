package com.rersdev.eduxpert.controllers;

import com.rersdev.eduxpert.controllers.dto.insert.NewTeacher;
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
@RequestMapping("/teacher")
public class TeacherController {

    private final ITeacherService teacherService;

    @PostMapping
    public ResponseEntity<?> saveNewTeacher(@RequestBody NewTeacher teacherDto)
            throws URISyntaxException {
        teacherService.save(teacherDto);
        return ResponseEntity.created(new URI("/eduxpert/api/v1/endpoints/teacher")).build();
    }

    @GetMapping
    public ResponseEntity<?> getTeacher(
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
