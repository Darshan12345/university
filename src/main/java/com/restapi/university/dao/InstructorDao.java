package com.restapi.university.dao;

import com.restapi.university.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InstructorDao  extends JpaRepository<Instructor,Integer> {


}
