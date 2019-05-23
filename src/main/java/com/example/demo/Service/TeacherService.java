package com.example.demo.Service;

import com.example.demo.Domain.CourseTeacher;
import com.example.demo.Domain.StudentCourse;
import com.example.demo.Domain.Teacher;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.CourseTeacherRepository;
import com.example.demo.repository.StudentCourseRepository;
import com.example.demo.repository.TeacherRepository;
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

    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    //在绑定老师ID的时候查看学号和姓名是否存在于数据库里，对应接口3
    public int isteacher(int teaid,String name){
        List<Teacher> teachers = teacherRepository.findByTeacherIdAndAndTeachername(teaid, name);
        if (teachers.size() == 0) return 0;
        else return 1;
    }

    @Transactional
    //为老师添加密码，对应接口4
    public void setpassword(int stuid,String password){
        Teacher teacher = teacherRepository.findByTeacherId(stuid);
        teacher.setPassword(password);
    }

    @Transactional
    //通过教师的id获取教师某日的全部课程
    //依次返回：课程名、课程id、节数
    //接口9
    public List<List<String>> get_teacher_course(int teaid,String time){

        List<Integer> all_course = new ArrayList<>();
        List<List<String>> finall = new ArrayList<>();
        List<CourseTeacher> list = courseTeacherRepository.findByTeacherId(teaid);
        System.out.println(list.size());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0;i<list.size();i++){
            Date date = courseRepository.findByCourseId(list.get(i).getCourseId()).getDate();
            System.out.println(formatter.format(date));
            String form = formatter.format(date);
            if (form.equals(time)){
                System.out.println(i);
                all_course.add(list.get(i).getCourseId());
            }
        }

        for(int i=0;i<all_course.size();i++)
        {
            List<String> alist = new ArrayList<>();

            alist.add(courseRepository.findByCourseId(all_course.get(i)).getCoursename());
            alist.add(String.valueOf(courseRepository.findByCourseId(all_course.get(i)).getCourseId()));
            alist.add(String.valueOf(courseRepository.findByCourseId(all_course.get(i)).getJieshu()));
            finall.add(alist);


        }

        return finall;
    }
}
