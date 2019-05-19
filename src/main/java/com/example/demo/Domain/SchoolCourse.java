package com.example.demo.Domain;

import javax.persistence.*;

@Entity
@Table(name = "schoolcourse")
public class SchoolCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="schoolcourse_id")
    private int schoolcourseId;

    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "course_id")
    private int courseId;

    public int getSchoolcourseId() {
        return schoolcourseId;
    }

    public void setSchoolcourseId(int schoolcourseId) {
        this.schoolcourseId = schoolcourseId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
