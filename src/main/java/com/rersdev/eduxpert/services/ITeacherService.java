package com.rersdev.eduxpert.services;

import com.rersdev.eduxpert.controllers.dto.get.GetTeacher;
import com.rersdev.eduxpert.controllers.dto.insert.NewTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeacherService {

    Page<GetTeacher> findAll(Pageable pageable);

    void save(NewTeacher teacher);
}
