package com.restapi.university.service;

import com.restapi.university.dao.StudentDao;
import com.restapi.university.entity.Course;
import com.restapi.university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService  {

    @Autowired
    StudentDao studentDao;
    public  void addStudent(Student student)
    {
        studentDao.save(student);
    }

    public void deleteStudentById(int studentId)
    {
        studentDao.deleteById(studentId);
    }

    public void updateStudent(Student student)
    {


            Student temp=studentDao.findById(student.getId()).get();

            student.setCourses(temp.getCourses());
           // System.out.println(temp.getCourses());
        studentDao.save(student);
    }

    public void addCourse(int studentId, Course courseList)
    {

        Student student=studentDao.findById(studentId).get();
        student.addCourse(courseList);
        studentDao.save(student);

    }
    public void deleteCourse(int studentId, int courseId)
    {
        Student student=studentDao.findById(studentId).get();

        List<Course> courseList= student.getCourses();

        courseList.removeIf(course -> course.getId()==courseId);

        student.setCourses(courseList);
        studentDao.save(student);



    }

    public List<Student> getAllStudent(){
        return studentDao.findAll();
    }
}
