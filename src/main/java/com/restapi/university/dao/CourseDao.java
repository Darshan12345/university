package com.restapi.university.dao;

import com.restapi.university.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Integer> {


}
