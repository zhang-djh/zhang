package com.example.demo.Controller;

import com.example.demo.Service.ParentService;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ParentService parentService;

    @RequestMapping("/signin")
    @ResponseBody
    //在注册认证的时候查看是否符合认证条件，对应接口1，3，5
    public int signin(@RequestBody Map map){
        int role = (int) map.get("role");
        int id = (int) map.get("id");
        String name = (String) map.get("name");
        int ans = 0;
        if (role == 1){
            ans = studentService.isstudent(id,name);
        }else if(role == 2){
            ans = teacherService.isteacher(id,name);
        }else {
            ans = parentService.isparent(id,name);
        }
        return ans;
    }

    @RequestMapping("/setpasswd")
    @ResponseBody
    //认证成功后输入密码，对应接口2，4，6
    public void setpasswd(@RequestBody Map map){
        int id = (int)map.get("id");
        String password = (String)map.get("password");
        int role = (int)map.get("role");
        if (role == 1){
            studentService.setpassword(id,password);
        }else if(role == 2){
            teacherService.setpassword(id,password);
        }else {
            parentService.setpassword(id,password);
        }
    }

    @RequestMapping("/loginin")
    @ResponseBody
    //登录接口，对应接口7
    public int loginin(@RequestBody Map map){
        int id = (int)map.get("id");
        String passwd = (String)map.get("passwd");
        int role = (int)map.get("role");
        int ans = 0;
        if (role == 1){
            ans = studentService.stulogin(id,passwd);
        }else if(role == 2){
            ans = teacherService.tealogin(id,passwd);
        }else {
            ans = parentService.parlogin(id,passwd);
        }
        return ans;
    }
}
