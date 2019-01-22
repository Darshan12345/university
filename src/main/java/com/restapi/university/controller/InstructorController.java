package com.restapi.university.controller;

import com.restapi.university.dao.InstructorDao;
import com.restapi.university.entity.Course;
import com.restapi.university.entity.Instructor;
import com.restapi.university.entity.InstructorDetail;
import com.restapi.university.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @RequestMapping("/instructor")
    public List<Instructor> getAllInstructlr(){return instructorService.getAllInstructor();}

    @RequestMapping("/instructor/{instructorId}")
    public Instructor getInstructorById(@PathVariable int instructorId)
    {
        return instructorService.findInstructorById(instructorId);
    }

    @DeleteMapping("/instructor/{instructorId}")
    public void deleteInstructorById(@PathVariable int instructorId)
    {
        instructorService.deleteInstructorById(instructorId);
    }

    @PostMapping("/instructor")
    public void saveInstructor(@RequestBody Instructor instructor)
    {
        instructorService.saveInstructor(instructor);
    }
    @PostMapping("/instructor/{instructorId}/saveInstructorDetail")
    public void saveInstructor(@RequestBody InstructorDetail instructorDetail, @PathVariable int instructorId)
    {
        instructorService.saveInstructorDetail(instructorDetail, instructorId);
    }

    @PutMapping("/instructor/{instructorId}/saveInstructorDetail")
    public void updateInstructorDetail(@RequestBody InstructorDetail instructorDetail, @PathVariable int instructorId)
    {
        instructorService.updateInstructionDetail(instructorId,instructorDetail);
    }

    @PutMapping("/instructor/{instructorId}")
    public void updateInstructor(@RequestBody Instructor instructor,@PathVariable int instructorId)
    {
        instructorService.updateInstructor(instructorId, instructor);
    }

    @PostMapping("/instructor/{instructorId}/addCourse")
    public void addCourseToInstructor(@RequestBody Course course, @PathVariable int instructorId)
    {
        instructorService.addCourseToInstructor(instructorId,course);
    }

    @PutMapping("/instructor/{instructorId}/updateCourse")
    public void updateCourseToInstructor(@RequestBody Course course, @PathVariable int instructorId)
    {
        instructorService.updateCourse(instructorId,course);
    }

}
