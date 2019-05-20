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
        List<Integer> list = studentService.getallstu(4);
        for (int i=0;i<list.size();i++)
        {
            System.out.println(studentRepository.findByStudentId(list.get(i)).getName());
        }
    }

    @RequestMapping("/main")
    public String main()
    {
        return "hzjnb";
    }
}
