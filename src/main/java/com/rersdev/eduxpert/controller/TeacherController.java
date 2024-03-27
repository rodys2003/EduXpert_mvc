package com.rersdev.eduxpert.controller;

import com.rersdev.eduxpert.controller.dto.insert.NewTeacher;
import com.rersdev.eduxpert.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

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
            Pageable pageable){
        return ResponseEntity.ok().body(teacherService.findAll(pageable));
    }
}
