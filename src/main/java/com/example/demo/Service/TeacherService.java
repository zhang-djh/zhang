package com.example.demo.Service;

import com.example.demo.Domain.CourseTeacher;
import com.example.demo.Domain.StudentCourse;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CourseTeacherRepository;
import com.example.demo.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private CourseTeacherRepository courseTeacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    //通过教师的id获取教师某日的全部课程
    public List<String> get_teacher_course(int teaid,String time){

        List<String> all_course = new ArrayList<>();
        List<CourseTeacher> list = courseTeacherRepository.findByTeacherId(teaid);
        System.out.println(list.size());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0;i<list.size();i++){
            Date date = courseRepository.findByCourseId(list.get(i).getCourseId()).getDate();
            System.out.println(formatter.format(date));
            String form = formatter.format(date);
            if (form.equals(time)){
                System.out.println(i);
                all_course.add(courseRepository.findByCourseId(list.get(i).getCourseId()).getCoursename());
            }
        }
        return all_course;
    }
}
