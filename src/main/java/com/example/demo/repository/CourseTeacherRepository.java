package com.example.demo.repository;

import com.example.demo.Domain.CourseTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CourseTeacherRepository extends CrudRepository<CourseTeacher, Integer>, JpaRepository<CourseTeacher, Integer>, PagingAndSortingRepository<CourseTeacher,Integer>, JpaSpecificationExecutor<CourseTeacher> {


}
