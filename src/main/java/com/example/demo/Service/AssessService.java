package com.example.demo.Service;

import com.example.demo.Domain.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Domain.Assess;
import com.example.demo.Domain.AssessContent;
import com.example.demo.repository.AssessContentRepository;
import com.example.demo.repository.AssessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class AssessService {

    @Autowired
    private AssessRepository assessRepository;

    @Autowired
    private AssessContentRepository assessContentRepository;

    @Autowired
    private CourseRepository courseRepository;


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
    public Map<String,Integer> get_student_assess_from_teacher(int courseid,int stuid,int teaid) {
        List<AssessContent> ad = assessContentRepository.findByCourseId(courseid);
        Map<String, Integer> content = new HashMap();
        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < ad.size(); i++) {
            String key = ad.get(i).getContent();
            List<Assess> as = assessRepository.findByAssesscontentIdAndAndBeassessIdAndAssesserId(ad.get(i).getAssesscontentId(), stuid, teaid);
            int num = assessRepository.findByAssesscontentIdAndAndBeassessIdAndAssesserId(ad.get(i).getAssesscontentId(), stuid, teaid).get(0).getAssessnum();
            content.put(key, num);
        }
        return content;
    }

    @Transactional
    //已知学生id、课程id，找到同学的所有评价，并取平均值
    //接口15
    public HashMap<String,Float> getallassess(int stuid,int courseid)
    {
        List<AssessContent> assessContentslist = assessContentRepository.findByCourseId(courseid);
        List<Integer> contentids = new ArrayList<>();
        List<Integer> assesslist = new ArrayList<>();
        List<Integer> finallist = new ArrayList<>();//存的是该课程对该同学所有评价的assessid
        HashMap<Integer,Integer> value = new HashMap<>();
        HashMap<String,Float> assessmap = new HashMap<>();
        for (int i=0;i<assessContentslist.size();i++)
        {
            contentids.add(assessContentslist.get(i).getAssesscontentId());
        }
        for (int i=0;i<contentids.size();i++)
        {
            List<Assess> alist = assessRepository.findByAssesscontentId(contentids.get(i));
            for (int j=0;j<alist.size();j++)
            {
                assesslist.add(alist.get(j).getAssessId());
            }
        }
        for (int i=0;i<assesslist.size();i++)
        {
            int a = assessRepository.findByAssessId(assesslist.get(i)).getBeassessId();
            if(a==stuid)
            {
                finallist.add(assesslist.get(i));
            }
        }

        for (int i=0;i<finallist.size();i++)
        {
            if(value.containsKey(assessRepository.findByAssessId(finallist.get(i)).getAssesscontentId()))
            {
                Iterator iter = value.entrySet().iterator();
                int index = 1;
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    Object key = entry.getKey();
                    Object val = entry.getValue();
                    if((int)key==assessRepository.findByAssessId(finallist.get(i)).getAssesscontentId())
                    {
                        value.replace(index,(int)val+assessRepository.findByAssessId(finallist.get(i)).getAssessnum());
                    }
                    index++;
                }
            }
            else
                value.put(assessRepository.findByAssessId(finallist.get(i)).getAssesscontentId(),assessRepository.findByAssessId(finallist.get(i)).getAssessnum());
        }



        Iterator iter = value.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            int num=0;
            for(int i=0;i<finallist.size();i++)
            {
                if(assessRepository.findByAssessId(finallist.get(i)).getAssesscontentId()==(int)key)
                    num++;
            }
            System.out.println(num);
            assessmap.put(assessContentRepository.findByAssesscontentId((int)key).getContent(),Float.valueOf(String.valueOf((int)val))/num);
        }

        return assessmap;
    }






    @Transactional
    //评价,获取他人对某同学的评价，并存入数据库
    //List里第一条是contentid，第二条num
    //接口13
    public void assess(int asssesserid,int beassessedid,int courseid,List<List<String>> list)
    {
        for (int i=0;i<list.size();i++)
        {
            Assess a = new Assess();
            a.setAssesserId(asssesserid);
            a.setBeassessId(beassessedid);
            a.setAssesscontentId(Integer.valueOf(list.get(i).get(0)));
            a.setAssessnum(Integer.valueOf(list.get(i).get(1)));
            assessRepository.save(a);
        }
    }


    @Transactional
    //获得评价内容
    //接口12
    //依次返回：评论内容、评论id
    public List<List<String>> getcontent(int courseid)
    {
        List<AssessContent> contents = assessContentRepository.findByCourseId(courseid);
        List<List<String>> finall = new ArrayList<>();
        for (int i=0;i<contents.size();i++)
        {
            List<String> alist = new ArrayList<>();
            alist.add(contents.get(i).getContent());
            alist.add(String.valueOf(contents.get(i).getAssesscontentId()));
            finall.add(alist);
        }
        return finall;
    }

    @Transactional
    //若登陆者对该同学评价过，查看评价内容
    //接口14
    //参数分别是：被评人id，课程id，评价人id（登陆者）
    public List<List<String>> get_his_assess(int studentid,int courseid,int assesserid)
    {
        List<List<String>> getassesslist = new ArrayList<>();
        List<Assess> oklist = new ArrayList<>();
        List<Assess> assesslist = assessRepository.findByAssesserIdAndBeassessId(assesserid,studentid);
        for (int i=0;i<assesslist.size();i++)
        {
            if (assessContentRepository.findByAssesscontentId(assesslist.get(i).getAssesscontentId()).getCourseId()==courseid)
                oklist.add(assesslist.get(i));
        }

        for (int i=0;i<oklist.size();i++)
        {
            List<String> alist = new ArrayList<>();
            alist.add(assessContentRepository.findByAssesscontentId(assesslist.get(i).getAssesscontentId()).getContent());
            alist.add(String.valueOf(assesslist.get(i).getAssessnum()));
            getassesslist.add(alist);
        }
        return getassesslist;
    }

    @Transactional
    //教师新加评价，接口16
    public void add_assess_fromteacher(String name,String content){
        List<Course> courses = courseRepository.findByCoursename(name);
        for (int i = 0;i < courses.size();i++) {
            AssessContent ac = new AssessContent(content, 1, courses.get(i).getCourseId());
            assessContentRepository.save(ac);
        }
    }

    @Transactional
    //教务添加评价，接口17
    public void add_assess_fromadmin(String content){
        List<Course> courses = courseRepository.findAll();
        List<Integer> contents = new ArrayList<>();
        for (int i = 0;i <courses.size();i++){
            contents.add(courses.get(i).getCourseId());
        }
        for (int i = 0;i<contents.size();i++){
            AssessContent ac = new AssessContent(content,0,contents.get(i));
            assessContentRepository.save(ac);
        }
    }

}
