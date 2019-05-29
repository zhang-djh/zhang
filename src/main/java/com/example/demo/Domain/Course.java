package com.example.demo.Domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="course_id")
    private int courseId;

    @Column(name = "coursename")
    private String coursename;

    @Column(name = "jieshu")
    private int jieshu;

    @Column(name = "date")
    private Date date;

    @Column(name = "assess_num")
    private int assessNum;

    public int getAssessNum() {
        return assessNum;
    }

    public void setAssessNum(int assessNum) {
        this.assessNum = assessNum;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getJieshu() {
        return jieshu;
    }

    public void setJieshu(int jieshu) {
        this.jieshu = jieshu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
