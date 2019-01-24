package com.restapi.university.dao;

import com.restapi.university.entity.Course;
import com.restapi.university.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDao extends JpaRepository<Course, Integer> {



}
