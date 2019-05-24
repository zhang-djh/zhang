package com.example.demo.Controller;

import com.example.demo.Service.AssessService;
import com.example.demo.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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


    @RequestMapping("/isassessed")
    @ResponseBody
    //查看是否给这个人评价过，评价过返回1，未评价返回0
    public void isassessed(){
        int is = assessService.get_studentid_by_course(2,1,2);
        if (is == 1)
            System.out.println("has been assessed");
        else System.out.println("no assessed");
    }

    @RequestMapping("/assessnum")
    @ResponseBody
    //已知学生id、课程id，老师id，找到该老师给与该同学的评价
    public void assessnum(){
        Map<String,Integer> map = assessService.get_student_assess_from_teacher(1,1,2);
        for(String key : map.keySet()){
            int value = map.get(key);
            System.out.println(key+" : "+value);
        }
    }

    @RequestMapping("/teacheraddassess")
    @ResponseBody
    //老师给具体某一节课添加评论，对应接口16
    public void addfromteacher(
//            int courid,String content
    ){
        int courid = 1;
        String content = "是否膜洪少";
        assessService.add_assess_fromteacher(courid,content);
    }

    @RequestMapping("adminaddassess")
    @ResponseBody
    public void addfromadmin(
//            String content
    ){
        String content = "教务加的评论";
        assessService.add_assess_fromadmin(content);
    }
}
