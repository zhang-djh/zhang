package com.example.demo.Controller;


import com.example.demo.Domain.Parent;
import com.example.demo.Domain.Student;
import com.example.demo.repository.ParentRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/main")
public class Main {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ParentRepository parentRepository;

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
        Parent p = parentRepository.findByStudentId(1);
        Student s = studentRepository.findByStudentId(p.getStudentId());
        System.out.println(s.getName());
    }

    @RequestMapping("/main")
    public String main()
    {
        return "hzjnb";
    }
}
