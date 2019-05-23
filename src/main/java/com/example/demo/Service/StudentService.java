package com.example.demo.Service;

import com.example.demo.Domain.Student;
import com.example.demo.Domain.StudentCourse;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentCourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private StudentRepository studentRepository;


    @Transactional
    //在绑定学生ID的时候查看学号和姓名是否存在于数据库里，对应接口1
    public int isstudent(int stuid,String name){
        List<Student> student = studentRepository.findByStudentIdAndAndName(stuid,name);
        if (student.size() == 0) return 0;
        else return 1;
    }

    @Transactional
    //为学生添加密码，对应接口2
    public void setpassword(int stuid,String password){
        Student student = studentRepository.findByStudentId(stuid);
        student.setPassword(password);
    }


    @Transactional
    //获得该同学所有的课程,并且是指定的日期,日期格式是yyyy-mm-dd
    public List<String> gethiscourse(int stuid,String time)
    {
        List<Integer> allcourses = new ArrayList<>();
        List<StudentCourse> list = studentCourseRepository.findByStudentId(stuid);//获得该同学所有课程，但没有考虑时间
        List<String> courselist = new ArrayList<>();
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

        for (int i=0;i<allcourses.size();i++)
        {
            courselist.add(courseRepository.findByCourseId(allcourses.get(i)).getCoursename());
        }
        return courselist;
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
