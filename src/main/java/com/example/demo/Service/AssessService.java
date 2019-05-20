package com.example.demo.Service;

import com.example.demo.Domain.*;
import com.example.demo.repository.AssessContentRepository;
import com.example.demo.repository.AssessRepository;
import com.example.demo.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AssessService {

    @Autowired
    private AssessRepository assessRepository;

    @Autowired
    private AssessContentRepository assessContentRepository;

    @Transactional
    //通过课程id,被评价人id，课程id看看某个人是否被用户评价过,评价过返回1，没有评价过返回0
    public int get_studentid_by_course(int courseid,int assessid,int beassessedid){
        List<AssessContent> ac = assessContentRepository.findByCourseId(courseid);
        int content = ac.get(0).getAssesscontentId();
        System.out.println(content);
        List<Assess> ass = assessRepository.findByAssesscontentIdAndAndBeassessIdAndAssesserId(content,beassessedid,assessid);
        System.out.println(ass.size());
        if (ass.size() == 0)
            return 0;
        else return 1;
    }

    @Transactional
    //老师查看某个学生对应某节课由老师授予的评价的值
    public Map<String,Integer> get_student_assess_from_teacher(int courseid,int stuid,int teaid){
        List<AssessContent> ad = assessContentRepository.findByCourseId(courseid);
        Map<String,Integer> content = new HashMap();
        List<Map<String,Integer>> list = new ArrayList<>();
        for (int i = 0;i<ad.size();i++){
            String key = ad.get(i).getContent();
            List<Assess> as = assessRepository.findByAssesscontentIdAndAndBeassessIdAndAssesserId(ad.get(i).getAssesscontentId(),stuid,teaid);
            int num = assessRepository.findByAssesscontentIdAndAndBeassessIdAndAssesserId(ad.get(i).getAssesscontentId(),stuid,teaid).get(0).getAssessnum();
            content.put(key,num);
        }
        return content;
    }
}
