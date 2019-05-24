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
    //已知某节课，得到所有同学的id和他们是否被评价过，map<同学id，评价过为1，为评价过为0>，对应接口11
    public Map<Integer, Integer> getallstu(int courseid,int assesserid)
    {
        Map<Integer, Integer> list = studentService.getallstu(courseid,assesserid);
        return list;
    }

    @RequestMapping("/getstuname")
    @ResponseBody
    //通过学生id获得学生的姓名，辅助接口11
    public Map<Integer,String> stuname(List<Integer> stuid){
        Map<Integer,String> stunames = studentService.getstuname(stuid);
        return stunames;
    }
}
