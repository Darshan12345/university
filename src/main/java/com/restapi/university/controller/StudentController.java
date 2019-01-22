package com.restapi.university.controller;

import com.restapi.university.dao.StudentDao;
import com.restapi.university.entity.Course;
import com.restapi.university.entity.Student;
import com.restapi.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("api/")
public class StudentController {


    @Autowired
    StudentService studentService;

    @RequestMapping("/students")
    public List<Student> getAllStudent(){
       return studentService.getAllStudent();}


    @PostMapping("/students")
    public void addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }

    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student)
    {
        studentService.updateStudent(student);
    }

    @PostMapping("/students/addCourse/{studentId}")
    public void addCourse(@RequestBody Course course, @PathVariable int pathVariable)
    {
        studentService.addCourse(pathVariable,course);
    }


    @DeleteMapping("/students/deleteCourse/{studentId}/{courseId}")
    public void deleteCourse(@PathVariable int studentId, @PathVariable int courseId){

        studentService.deleteCourse(studentId,courseId);
    }
}
