package com.restapi.university.controller;

import com.restapi.university.entity.Course;
import com.restapi.university.entity.Instructor;
import com.restapi.university.entity.InstructorDetail;
import com.restapi.university.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class InstructorController {

    @Autowired
    InstructorService instructorService;


    @RequestMapping("/instructor")
    public List<Instructor> getAllInstructor(){return instructorService.getAllInstructor();}

    @RequestMapping("/instructor/{instructorId}")
    public Instructor getInstructorById(@PathVariable int instructorId)
    {
        return instructorService.findInstructorById(instructorId);
    }

    @DeleteMapping("/instructor/{instructorId}")
    public ResponseEntity<Integer> deleteInstructorById(@PathVariable int instructorId)
    {
        Instructor instructor = instructorService.findInstructorById(instructorId);
        if(instructor!=null) {
            instructorService.deleteInstructorById(instructorId);
            return new ResponseEntity<>(instructorId, HttpStatus.ACCEPTED);

        }else {
            return new ResponseEntity<>(instructorId, HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping("/instructor")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor)
    {
       // System.out.println(instructor);
        instructorService.saveInstructor(instructor);
        return new ResponseEntity<>(instructor, HttpStatus.CREATED);
    }


    @PostMapping("/instructor/{instructorId}/saveInstructorDetail")
    public ResponseEntity<?> saveInstructor(@RequestBody InstructorDetail instructorDetail, @PathVariable int instructorId)
    {
        instructorService.saveInstructorDetail(instructorDetail, instructorId);
        return new ResponseEntity<>(instructorDetail, HttpStatus.CREATED);
    }

        @PutMapping("/instructor/{instructorId}/saveInstructorDetail")
    public void updateInstructorDetail(@RequestBody InstructorDetail instructorDetail, @PathVariable int instructorId)
    {
        instructorService.updateInstructionDetail(instructorId,instructorDetail);
    }

    @PutMapping("/instructor/{instructorId}")
    public void updateInstructor(@RequestBody Instructor instructor,@PathVariable int instructorId)
    {
       // System.out.println(instructor);
        instructorService.updateInstructor(instructorId, instructor);
    }

        @PostMapping("/instructor/{instructorId}/course")
        public void addCourseToInstructor(@RequestBody Course course, @PathVariable int instructorId)
        {
            instructorService.addCourseToInstructor(instructorId,course);
        }

            @PutMapping("/instructor/{instructorId}/course")
    public void updateCourseToInstructor(@RequestBody Course course, @PathVariable int instructorId)
    {
        instructorService.updateCourse(instructorId,course);
    }


    @GetMapping("/instructor/{instructorId}/course")
    public List<Course> getAllCourseById(@PathVariable int instructorId)
    {
        return instructorService.findInstructorById(instructorId).getCourses();
    }
}
