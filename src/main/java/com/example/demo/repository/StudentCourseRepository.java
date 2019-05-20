package com.example.demo.repository;

import com.example.demo.Domain.SchoolCourse;
import com.example.demo.Domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentCourseRepository extends CrudRepository<StudentCourse, Integer>, JpaRepository<StudentCourse, Integer>, PagingAndSortingRepository<StudentCourse,Integer>, JpaSpecificationExecutor<StudentCourse> {
    List<StudentCourse> findByStudentId(int studentid);

    List<StudentCourse> findByCourseId(int courseid);
}
