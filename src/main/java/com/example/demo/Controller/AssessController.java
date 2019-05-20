package com.example.demo.Controller;

import com.example.demo.Service.AssessService;
import com.example.demo.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/assess")
public class AssessController {

    @Autowired
    private ClassService classService;

    @Autowired
    private AssessService assessService;

    @RequestMapping("/getallcontent")
    //得到某节课的所有评价指标
    @ResponseBody
    public void getallcontent(int courseid)
    {
        List<String> list = classService.getallcontent(courseid);
    }

    @RequestMapping("/getallassess")
    @ResponseBody
    //已知学生id、课程id，找到同学的所有评价，并取平均值
    public void getallassess(int stuid,int courseid)
    {
        assessService.getallassess(stuid,courseid);
    }
}
