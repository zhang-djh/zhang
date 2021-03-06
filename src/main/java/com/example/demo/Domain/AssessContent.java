package com.example.demo.Domain;

import javax.persistence.*;

@Entity
@Table(name = "assesscontent")
public class AssessContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="assesscontent_id")
    private int assesscontentId;

    @Column(name = "content")
    private String content;

    @Column(name = "person_class")
    private int personClass;

    @Column(name = "course_id")
    private int courseId;

    public AssessContent(String content,int personClass,int courseId){
        this.assesscontentId = 0;
        this.content = content;
        this.personClass = personClass;
        this.courseId = courseId;
    }

    public int getAssesscontentId() {
        return assesscontentId;
    }

    public void setAssesscontentId(int assesscontentId) {
        this.assesscontentId = assesscontentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPersonId() {
        return personClass;
    }

    public void setPersonId(int personId) {
        this.personClass = personId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
