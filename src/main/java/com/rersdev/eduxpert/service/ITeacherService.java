package com.rersdev.eduxpert.service;

import com.rersdev.eduxpert.controller.dto.get.GetTeacher;
import com.rersdev.eduxpert.controller.dto.insert.NewTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeacherService {

    Page<GetTeacher> findAll(Pageable pageable);

    void save(NewTeacher teacher);
}
