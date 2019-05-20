package com.example.demo.Controller;


import com.example.demo.Domain.Course;
import com.example.demo.Domain.Parent;
import com.example.demo.Domain.Student;
import com.example.demo.Service.StudentService;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.ParentRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/main")
public class Main {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private StudentService studentService;



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
        String time = "2019-05-20";
        System.out.println(time);
        List<Integer> list = studentService.gethiscourse(1,time);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        System.out.println("----------");
    }

    @RequestMapping("/main")
    public String main()
    {
        return "hzjnb";
    }
}
