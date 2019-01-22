package com.restapi.university.controller;

import com.restapi.university.entity.Course;
import com.restapi.university.entity.Review;
import com.restapi.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourse(){
       return courseService.getAllCourse();
    }
    @GetMapping("/courses/{courseId}")
    public void getCourseById(@PathVariable int courseId){
        courseService.getCourseById(courseId);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable int courseId){
        courseService.deleteCourseById(courseId);
    }

    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course)
    {
        courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public void updateCourse(@RequestBody Course course)
    {
        courseService.updateCourse(course);
    }


}
