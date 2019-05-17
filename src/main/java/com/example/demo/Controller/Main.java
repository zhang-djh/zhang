package com.example.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {

    @RequestMapping("/test")
    public String test()
    {
        return "index";
    }


    @RequestMapping("/main")
    public String main()
    {
        return "lzfnb";
    }
}
