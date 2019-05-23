package com.example.demo.Controller;

import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getcourse")
    @ResponseBody
    //获得该同学所有的课程,并且是指定的日期,日期格式是yyyy-mm-dd
    //返回依次是：课程名、课程id、课程节数
    //接口8
    public void getcourse(int stuid,String date)
    {

        List<List<String>> list = studentService.gethiscourse(stuid,date);
    }

    @RequestMapping("/getallstu")
    @ResponseBody
    //已知某节课，得到所有同学的id
    public void getallstu(int courseid,int assesserid)
    {
        Map<Integer, Integer> list = studentService.getallstu(courseid,assesserid);
    }
}
