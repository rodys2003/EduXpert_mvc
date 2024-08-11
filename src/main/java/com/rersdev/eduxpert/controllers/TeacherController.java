package com.rersdev.eduxpert.controllers;

import com.rersdev.eduxpert.config.advice.user.UserNotFoundException;
import com.rersdev.eduxpert.dto.users.teacher.*;
import com.rersdev.eduxpert.services.ITeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<URI> saveNewTeacher(@RequestBody @Valid TeacherDto teacherDto)
            throws URISyntaxException {
        UUID id = teacherService.save(teacherDto);
        return ResponseEntity.created(new URI("/eduxpert/api/v1/endpoints/teachers/" + id)).build();
    }

    @GetMapping
    public ResponseEntity<Page<TeacherInfoDto>> getAllTeachers(
            @RequestParam(required = false) String status,
            @RequestParam boolean isActive,
            @PageableDefault(sort = "person.lastName")
            Pageable pageable) {
        return ResponseEntity.ok().body(teacherService.findAll(status, isActive, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherPartialInfoDto> getTeacherById(@PathVariable UUID id) {
        return teacherService.findById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException("No se ha encontrado el profesor con id: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherPartialInfoDto> updateTeacherPartial(
            @PathVariable UUID id,
            @RequestBody @Valid TeacherPartialUpdateDto teacherUpdated) {
        return ResponseEntity.ok().body(teacherService.partialUpdate(id, teacherUpdated));
    }

    @PutMapping("/{id}/")
    public ResponseEntity<TeacherInfoDto> updateTeacherInfo(@PathVariable UUID id,
                                                            @RequestBody @Valid TeacherUpdateDto teacherUpdated){
        return ResponseEntity.ok().body(teacherService.updateByAdmin(id, teacherUpdated
        ));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<String> updateTeacherStatus(
            @RequestParam String status,
            @PathVariable UUID id) {
        teacherService.updateStatus(status, id);
        return ResponseEntity.ok().body("Status updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable UUID id) {
        teacherService.deleteByAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
