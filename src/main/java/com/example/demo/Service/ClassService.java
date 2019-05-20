package com.example.demo.Service;

import com.example.demo.Domain.AssessContent;
import com.example.demo.repository.AssessContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {

    @Autowired
    private AssessContentRepository assessContentRepository;

    @Transactional
    //得到某节课的所有评价指标
    public List<String> getallcontent(int courseid)
    {
        List<String> allcontent = new ArrayList<>();
        List<AssessContent> teachercontent = assessContentRepository.findByCourseId(courseid);
        List<AssessContent> admincontent = assessContentRepository.findByCourseId(-1);
        for(int i=0;i<teachercontent.size();i++)
        {
            allcontent.add(teachercontent.get(i).getContent());
        }
        for (int i=0;i<admincontent.size();i++)
        {
            allcontent.add(admincontent.get(i).getContent());
        }

        return allcontent;
    }
}
