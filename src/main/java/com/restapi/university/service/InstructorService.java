package com.restapi.university.service;

import com.restapi.university.dao.CourseDao;
import com.restapi.university.dao.InstructorDao;
import com.restapi.university.entity.Course;
import com.restapi.university.entity.Instructor;
import com.restapi.university.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstructorService {

    @Autowired
    InstructorDao instructorDao;
    @Autowired
    CourseDao courseDao;
    public List<Instructor> getAllInstructor(){
        return instructorDao.findAll();

    }

    public Instructor findInstructorById(int id)
    {
        return instructorDao.findById(id).get();
    }


    public void deleteInstructorById(int instructorId)
    {
        instructorDao.deleteById(instructorId);
    }

    public void saveInstructor(Instructor instructor)
    {
        instructorDao.save(instructor);
    }

    public void saveInstructorDetail(InstructorDetail instructorDetail, int instructorId)
    {
        Instructor instructor=instructorDao.findById(instructorId).get();
        instructor.setInstructorDetail(instructorDetail);

        instructorDao.save(instructor);

    }


    public void updateInstructionDetail(int instructorId, InstructorDetail instructorDetail)
    {
        Instructor instructor=instructorDao.findById(instructorId).get();
        instructor.setInstructorDetail(instructorDetail);

        instructorDao.save(instructor);
    }


    public void updateInstructor(int instructorId, Instructor instructor)
    {
        Instructor tempInstructor= instructorDao.findById(instructorId).get();

        instructor.setInstructorDetail(tempInstructor.getInstructorDetail());
        instructor.setCourses(tempInstructor.getCourses());


        instructorDao.save(instructor);
    }

    public void addCourseToInstructor(int instructorId,  Course course)
    {
        Instructor instructor=instructorDao.findById(instructorId).get();
        course.setInstructor(instructor);

        courseDao.save(course);



    }

    public void updateCourse(int instructorId,Course course){


        Course tempCourse= courseDao.findById(instructorId).get();
        tempCourse.setTitle(course.getTitle());




        courseDao.save(tempCourse);


    }
    public void deleteCourseById(int courseId)
    {
        courseDao.deleteById(courseId);
    }




}
