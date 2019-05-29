package com.example.demo.Controller;

import com.example.demo.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentService parentService;

    @RequestMapping("/getchilecourse")
    @ResponseBody
    public List<List<String>> getchildcourse(@RequestBody Map map)
    {
        //int parentid,String date
        List<List<String>> list = parentService.getchildcourse((int)map.get("parentid"),(String)map.get("date"));
        return list;

    }

}
