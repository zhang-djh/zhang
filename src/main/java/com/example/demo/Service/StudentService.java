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
    public List<Integer> gethiscourse(int stuid)//获得该同学所有的课程,并且是指定的日期
    {
        List<Integer> allcourses = new ArrayList<>();
        List<StudentCourse> list = studentCourseRepository.findByStudentId(stuid);//获得该同学所有课程，但没有考虑时间
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today = formatter.format(currentTime);



        return allcourses;
    }
}
