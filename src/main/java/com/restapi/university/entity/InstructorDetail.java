package com.restapi.university.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {


    @GeneratedValue(strategy = GenerationType.AUTO)
            @Id
            @Column(name = "id")
    int id;


    @Column(name="youtube_channel", length = 100)
    String youtube_channel;


    @Column(name="hobby", length = 50)
    String hobby;

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtube_channel='" + youtube_channel + '\'' +
                ", hobby='" + hobby + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    public InstructorDetail(){}


    public InstructorDetail(String youtube_channel, String hobby, Instructor instructor) {
        this.youtube_channel = youtube_channel;
        this.hobby = hobby;
        this.instructor = instructor;
    }

    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutube_channel() {
        return youtube_channel;
    }

    public void setYoutube_channel(String youtube_channel) {
        this.youtube_channel = youtube_channel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
