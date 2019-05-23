package com.example.demo.Controller;

import com.example.demo.Service.ParentService;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public int signin(
//            int id,String name,int role
    ){
        int role = 3;
        int id = 1;
        String name = "niubi";
        int ans = 0;
        if (role == 1){
            ans = studentService.isstudent(id,name);
        }else if(role == 2){
            ans = teacherService.isteacher(id,name);
        }else {
            ans = parentService.isparent(id,name);
        }
        System.out.println(ans);
        return ans;
    }

    @RequestMapping("/setpasswd")
    @ResponseBody
    //认证成功后输入密码，对应接口2，4，6
    public void setpasswd(
//            int id,String password,int role
    ){
        int id = 1;
        String password = "test";
        int role = 3;
        if (role == 1){
            studentService.setpassword(id,password);
        }else if(role == 2){
            teacherService.setpassword(id,password);
        }else {
            parentService.setpassword(id,password);
        }
    }
}
