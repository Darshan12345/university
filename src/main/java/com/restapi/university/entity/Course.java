package com.restapi.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
public class Course {

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "id")
    int id;

    @Column(name="title")
    String title;

    @JsonIgnoreProperties(allowSetters=true, value = "courses")
@ManyToOne(fetch = FetchType.EAGER,cascade= {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
@JoinColumn(name = "instructor_id")
    Instructor instructor;

    @JsonManagedReference
@OneToMany(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "course")

    List<Review> reviews;


    @JsonIgnore()
@ManyToMany(fetch = FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
@JoinTable(name = "course_student",
        joinColumns = @JoinColumn(name="course_id"),
        inverseJoinColumns = @JoinColumn(name="student_id"))
List<Student> students;


    public Course() {

    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    // add a convenience method

    public void addReview(Review theReview) {

        if (reviews == null) {
            reviews = new ArrayList<>();
        }

        reviews.add(theReview);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // add a convenience method

    public void addStudent(Student theStudent) {

        if (students == null) {
            students = new ArrayList<>();
        }

        students.add(theStudent);
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + "]";
    }


}
