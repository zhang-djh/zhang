package com.example.demo.Controller;


import com.example.demo.Domain.Course;
import com.example.demo.Domain.Parent;
import com.example.demo.Domain.Student;
import com.example.demo.Service.AssessService;
import com.example.demo.Service.ClassService;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.TeacherService;
import com.example.demo.Service.AssessService;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class Main {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AssessService assessService;

    @RequestMapping("/test")
    public String test()
    {
        System.out.println("-----------------");
        return "index";
    }

    @RequestMapping("/teststu")
    @ResponseBody
    public void teststu()
    {
        List<String> list = classService.getallcontent(1);
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }

    @RequestMapping("/main")
    public String main()
    {
        return "hzjnb";
    }

    @RequestMapping("/teachercourse")
    @ResponseBody
    public void teachercourse(){
        List<String> ls = teacherService.get_teacher_course(1,"2019-05-20");
        for (int i = 0;i < ls.size();i++){
            System.out.println(ls.get(i));
        }
    }

    @RequestMapping("/isassessed")
    @ResponseBody
    public void isassessed(){
        int is = assessService.get_studentid_by_course(2,1,2);
        if (is == 1)
            System.out.println("has been assessed");
        else System.out.println("no assessed");
    }

    @RequestMapping("/assessnum")
    @ResponseBody
    public void assessnum(){
        Map<String,Integer> map = assessService.get_student_assess_from_teacher(1,1,2);
        for(String key : map.keySet()){
            int value = map.get(key);
            System.out.println(key+" : "+value);
        }
    }
}
