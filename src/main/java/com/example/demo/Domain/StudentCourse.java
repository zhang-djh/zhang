package com.example.demo.Domain;

import javax.persistence.*;

@Entity
@Table(name = "studentcourse")
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="student_course_id")
    private int studentcourseId;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public int getStudentcourseId() {
        return studentcourseId;
    }

    public void setStudentcourseId(int studentcourseId) {
        this.studentcourseId = studentcourseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
