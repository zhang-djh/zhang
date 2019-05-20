package com.example.demo.Controller;

import com.example.demo.Service.AssessService;
import com.example.demo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    //查看某个老师某天的所有课程
    @RequestMapping("/teachercourse")
    @ResponseBody
    public void teachercourse(){
        List<String> ls = teacherService.get_teacher_course(1,"2019-05-20");
        for (int i = 0;i < ls.size();i++){
            System.out.println(ls.get(i));
        }
    }
}
