package com.restapi.university.dao;

import com.restapi.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface     StudentDao  extends JpaRepository<Student, Integer> {

 }
