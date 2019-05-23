package com.example.demo.Controller;


import com.example.demo.Domain.Assess;
import com.example.demo.Domain.Course;
import com.example.demo.Domain.Parent;
import com.example.demo.Domain.Student;
import com.example.demo.Service.*;
import com.example.demo.Service.AssessService;
import com.example.demo.repository.AssessRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    private ParentService parentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AssessService assessService;

    @Autowired
    private AssessRepository assessRepository;

    @RequestMapping("/test")
    @ResponseBody
    public void test()
    {
        List<List<String>> list = assessService.get_his_assess(1,1,2);
        for (int i=0;i<list.size();i++)
            for (int j=0;j<list.get(i).size();j++)
                System.out.println(list.get(i).get(j));

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

}
