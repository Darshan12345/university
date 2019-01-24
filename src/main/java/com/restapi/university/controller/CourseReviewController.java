package com.restapi.university.controller;

import com.restapi.university.entity.Review;
import com.restapi.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseReviewController {

    @Autowired
    CourseService courseService;

    @GetMapping("{courseId}/review")
    public List<Review> getAllReview(@PathVariable int courseId){
        return courseService.getAllreviewById(courseId);

    }


    @PostMapping("{courseId}/review")
    public void addReview(@RequestBody Review review, @PathVariable int courseId)
    {
        courseService.addReview(review, courseId);
    }

    @PutMapping("{courseId}/review")
    public void updateReview(@RequestBody Review review, @PathVariable int courseId)
    {
        courseService.updateReview(review, courseId);
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable int reviewId)
    {
        courseService.deleteReview(reviewId);
    }
}
