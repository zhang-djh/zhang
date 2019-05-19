package com.example.demo.Service;

import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private CourseRepository courseRepository;

//    @Transactional
//    public List<Integer> gethiscourse(int stuid)
//    {
//        List<Integer> allcourses = new ArrayList<>();
////        courseRepository.
//    }
}
