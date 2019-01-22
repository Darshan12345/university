package com.restapi.university.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "id")
    int id;

    @Column(name = "comment", length = 100 ,nullable = false)
    String comment;


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn( name = "course_id")
    Course course;

    public Review(){}

    public int getId() {
        return id;
    }



    public Review(String comment) {
        this.comment = comment;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
