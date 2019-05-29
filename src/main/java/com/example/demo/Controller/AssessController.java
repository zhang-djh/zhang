package com.example.demo.Controller;

import com.example.demo.Service.AssessService;
import com.example.demo.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
    public List<String> getallcontent(@RequestBody Map map)
    {
        List<String> list = classService.getallcontent((int)map.get("courseid"));
        return list;
    }

    @RequestMapping("/getallassess")
    @ResponseBody
    //已知学生id、课程id，找到同学的所有评价，并取平均值
    public void getallassess(@RequestBody Map map)
    {
        assessService.getallassess((int)map.get("studentid"),(int)map.get("courseid"));
    }

    @RequestMapping("/getstuassess")
    @ResponseBody
    //接口15 获得其他同学对这名同学这节课的评价
    public HashMap<String,Float> getstuassess(@RequestBody Map map)
    {
        HashMap<String,Float> list = assessService.getallassess((int)map.get("stuid"),(int)map.get("courseid"));
        return list;
    }


    @RequestMapping("/isassessed")
    @ResponseBody
    //查看是否给这个人评价过，评价过返回1，未评价返回0
    public int isassessed(@RequestBody Map map){
        int is = assessService.get_studentid_by_course((int)map.get("courseid"),(int)map.get("assessid"),(int)map.get("beassessedid"));
        return is;
    }

    @RequestMapping("/getteacherassess")
    @ResponseBody
    //已知学生id、课程id，老师id，找到该老师给与该同学的评价
    //接口15
    public Map<String,Integer> assessnum(@RequestBody Map m){
        Map<String,Integer> map = assessService.get_student_assess_from_teacher((int)m.get("courseid"),(int)m.get("stuid"),(int)m.get("teaid"));
        return map;
    }

    @RequestMapping("/teacheraddassess")
    @ResponseBody
    //老师给具体某一节课添加评论，对应接口16
    public void addfromteacher(@RequestBody Map map){
        String name = (String)map.get("name");
        String content = (String)map.get("content");
        assessService.add_assess_fromteacher(name,content);
    }

    @RequestMapping("/getalreadyassess")
    @ResponseBody
    //接口14
    public List<List<String>> getalready(@RequestBody Map map)
    {
        //int studentid,int courseid,int assesserid
        List<List<String>> list = assessService.get_his_assess((int)map.get("studentid"),(int)map.get("courseid"),(int)map.get("assesserid"));
        return list;
    }


    @RequestMapping("adminaddassess")
    @ResponseBody
    //教务添加评论，对应接口17
    public void addfromadmin(@RequestBody Map map){
        String content = (String)map.get("content");
        assessService.add_assess_fromadmin(content);
    }

    @RequestMapping("getcourseassess")
    @ResponseBody
//    接口18
//    返回值：
//    一个hashmap<评价指标，评价平均值>
    public HashMap<String,Float> getcourseallassess(@RequestBody Map map)
    {
        HashMap<String,Float> a = new HashMap<>();
        a = assessService.getallstuassess((int)map.get("studentid"),(String)map.get("coursename"));
        return a;
    }

    @RequestMapping("/getassesscontent")
    @ResponseBody
    //接口12
    public List<List<String>> getcontent(@RequestBody Map map)
    {
        List<List<String>> list = assessService.getcontent((int)map.get("courseid"));
        return list;
    }

    @RequestMapping("/setassess")
    @ResponseBody
    //接口13
    public void setassess(@RequestBody Map map)
    {
        //int asssesserid,int beassessedid,int courseid,List<List<String>> list
        assessService.assess((int)map.get("assesserid"),(int)map.get("beassessedid"),(int)map.get("courseid"),(List<List<String>>)map.get("list"));
    }
}
