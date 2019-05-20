package com.example.demo.Service;

import com.example.demo.Domain.StudentCourse;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Transactional
    //获得该同学所有的课程,并且是指定的日期,日期格式是yyyy-mm-dd
    public List<Integer> gethiscourse(int stuid,String time)
    {
        List<Integer> allcourses = new ArrayList<>();
        List<StudentCourse> list = studentCourseRepository.findByStudentId(stuid);//获得该同学所有课程，但没有考虑时间
        System.out.println(list.size());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i<list.size();i++)
        {
            Date date = courseRepository.findByCourseId(list.get(i).getCourseId()).getDate();
            System.out.println(formatter.format(date));
            String form = formatter.format(date);
            if(form.equals(time))
            {
                System.out.println(i);
                allcourses.add(list.get(i).getCourseId());
            }
        }
        return allcourses;
    }


    @Transactional
    //已知某节课，得到所有同学的id
    public List<Integer> getallstu(int courseid)
    {
        List<Integer> students = new ArrayList<>();
        List<StudentCourse> all = studentCourseRepository.findByCourseId(courseid);
        System.out.println(all.size());
        for(int i=0;i<all.size();i++)
        {
            students.add(all.get(i).getStudentId());
        }
        return students;
    }


}
