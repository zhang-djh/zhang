package com.example.demo.Service;

import com.example.demo.Domain.Parent;
import com.example.demo.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private StudentService studentService;

    @Transactional
    //在绑定家长ID的时候查看学号和姓名是否存在于数据库里，对应接口5
    public int isparent(int stuid,String parname){
        List<Parent> parents = parentRepository.findByParentIdAndParentName(stuid,parname);
        if (parents.size() == 0) return  0;
        else  return 1;
    }

    @Transactional
    //为家长添加密码，对应接口6
    public void setpassword(int stuid,String password) {
        Parent parent = parentRepository.findByParentId(stuid);
        parent.setPassword(password);
    }

    @Transactional
    //家长登录接口，对应接口7
    public int parlogin(int id,String passwd){
        List<Parent> parents = parentRepository.findByParentIdAndPassword(id,passwd);
        if (parents.size() == 0) return 0;
        else  return 1;
    }
    @Transactional
    //已知家长id，找到学生的课程
    //接口10
    //返回依次是 课程名、课程id、节数
    public List<List<String>> getchildcourse(int parentid,String date)
    {
        List<List<String>> finall = new ArrayList<>();
        int stuid = parentRepository.findByParentId(parentid).getStudentId();
        finall = studentService.gethiscourse(stuid,date);
        return finall;
    }
}
