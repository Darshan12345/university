package com.restapi.university.controller;

import com.restapi.university.dao.InstructorDao;
import com.restapi.university.entity.Instructor;
import com.restapi.university.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @RequestMapping("/instructor")
    public List<Instructor> getAllInstructlr(){return instructorService.getAllInstructor();}
}
