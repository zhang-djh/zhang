package com.example.demo.repository;

import com.example.demo.Domain.Student;
import com.example.demo.Domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>, JpaRepository<Teacher, Integer>, PagingAndSortingRepository<Teacher,Integer>, JpaSpecificationExecutor<Teacher> {
    List<Teacher> findByTeacherIdAndAndTeachername(int id, String name);
    Teacher findByTeacherId(int teaid);
    List<Teacher> findByTeacherIdAndPassword(int id,String passwd);
}
