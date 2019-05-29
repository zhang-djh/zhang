package com.example.demo.Controller;

import com.example.demo.Service.AssessService;
import com.example.demo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    //查看某个老师某天的所有课程
    @RequestMapping("/teachercourse")
    @ResponseBody
    public List<List<String>> teachercourse(@RequestBody Map map){
        List<List<String>> ls = teacherService.get_teacher_course((int)map.get("teaid"),(String)map.get("date"));
        return  ls;
    }
}
