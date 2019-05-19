package com.example.demo.Domain;

import javax.persistence.*;

@Entity
@Table(name = "courseteacher")
public class CourseTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="course_teacher_id")
    private int courseTeacherId;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "teacher_id")
    private int teacherId;

    public int getCourseTeacherId() {
        return courseTeacherId;
    }

    public void setCourseTeacherId(int courseTeacherId) {
        this.courseTeacherId = courseTeacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
