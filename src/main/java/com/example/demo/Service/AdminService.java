package com.example.demo.Service;

import com.example.demo.Domain.AssessContent;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.AssessContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    @Autowired
    private AssessContentRepository assessContentRepository;

//    @Transactional
//    public void add_assess_content(String asscon){
//        adminRepository.save(asscon,0,);
//    }
}
