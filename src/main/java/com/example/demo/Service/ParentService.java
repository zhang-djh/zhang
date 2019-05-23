package com.example.demo.Service;

import com.example.demo.Domain.Parent;
import com.example.demo.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/parent")
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Transactional
    //在绑定家长ID的时候查看学号和姓名是否存在于数据库里，对应接口5
    public int isparent(int stuid,String parname){
        List<Parent> parents = parentRepository.findByParentIdAndParentName(stuid,parname);
        if (parents.size() == 0) return  0;
        else  return 1;
    }

    @Transactional
    //为家长添加密码，对应接口6
    public void setpassword(int stuid,String password){
        Parent parent = parentRepository.findByParentId(stuid);
        parent.setPassword(password);
    }
}
