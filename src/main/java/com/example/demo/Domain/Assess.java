package com.example.demo.Domain;

import javax.persistence.*;

@Entity
@Table(name = "assess")
public class Assess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="assess_id")
    private int assessId;

    @Column(name="assesscontent_id")
    private int assesscontentId;

    @Column(name = "assesser_id")
    private int assesserId;

    @Column(name = "beassessed_id")
    private int beassessId;

    @Column(name = "assessnum")
    private int assessnum;


    public int getAssessId() {
        return assessId;
    }

    public void setAssessId(int assessId) {
        this.assessId = assessId;
    }

    public int getAssesscontentId() {
        return assesscontentId;
    }

    public void setAssesscontentId(int assesscontentId) {
        this.assesscontentId = assesscontentId;
    }

    public int getAssesserId() {
        return assesserId;
    }

    public void setAssesserId(int assesserId) {
        this.assesserId = assesserId;
    }

    public int getBeassessId() {
        return beassessId;
    }

    public void setBeassessId(int beassessId) {
        this.beassessId = beassessId;
    }

    public int getAssessnum() {
        return assessnum;
    }

    public void setAssessnum(int assessnum) {
        this.assessnum = assessnum;
    }
}
