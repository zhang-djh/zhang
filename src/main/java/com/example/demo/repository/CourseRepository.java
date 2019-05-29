package com.example.demo.repository;

import com.example.demo.Domain.Course;
import com.example.demo.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer>, JpaRepository<Course, Integer>, PagingAndSortingRepository<Course,Integer>, JpaSpecificationExecutor<Course> {
    List<Course> findByCoursename(String name);

    Course findByCourseId(int id);
    List<Course> findByCoursename(String name);
}
