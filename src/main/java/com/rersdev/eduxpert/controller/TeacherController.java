package com.rersdev.eduxpert.controller;

import com.rersdev.eduxpert.persistence.entity.Teacher;
import com.rersdev.eduxpert.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private final ITeacherService teacherService;

    @PostMapping("/save")
    public ResponseEntity<Teacher> saveNewTeacher(@RequestBody Teacher teacher){
        return ResponseEntity.ok().body(teacherService.save(teacher));
    }
}
