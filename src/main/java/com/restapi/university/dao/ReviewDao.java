package com.restapi.university.dao;

import com.restapi.university.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends JpaRepository<Review,Integer> {
}
