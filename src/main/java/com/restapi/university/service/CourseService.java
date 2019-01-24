package com.restapi.university.service;

import com.restapi.university.dao.CourseDao;
import com.restapi.university.dao.ReviewDao;
import com.restapi.university.entity.Course;
import com.restapi.university.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseService {


    @Autowired
    CourseDao courseDao;

    @Autowired
    ReviewDao reviewDao;
    public List<Course> getAllCourse(){

       return courseDao.findAll();
    }

    public Course getCourseById(int id)
    {
        return courseDao.findById(id).orElse(null);
    }

    public void addCourse(Course course)
    {
        courseDao.save(course);
    }

    public  void updateCourse(Course course)
    {

        Course tempCourse= courseDao.findById(course.getId()).get();
        tempCourse.setTitle(course.getTitle());




        courseDao.save(tempCourse);




    }

    public void deleteCourseById(int courseId){

        courseDao.deleteById(courseId);
    }


    public void addReview(Review review, int courseId)
    {

      Course course=  courseDao.findById(courseId).get();
      review.setCourse(course);
      course.addReview(review);

      courseDao.save(course);

    }

        public void updateReview(Review review, int courseId)
    {
        Course course= courseDao.findById(courseId).get();
        List<Review> reviewList= course.getReviews();

        review.setCourse(course);
        reviewList.removeIf(review1 -> review.getId()==review1.getId());
        reviewList.add(review);

        course.setReviews(reviewList);

        courseDao.save(course);


    }

    public void deleteReview(int reviewId)
    {
        reviewDao.deleteById(reviewId);
    }

    public List<Review> getAllreviewById(int courseId)
    {
       return getCourseById(courseId).getReviews();
    }


}

