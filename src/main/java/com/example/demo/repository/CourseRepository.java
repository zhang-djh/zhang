package com.example.demo.repository;

import com.example.demo.Domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends CrudRepository<Course, Integer>, JpaRepository<Course, Integer>, PagingAndSortingRepository<Course,Integer>, JpaSpecificationExecutor<Course> {
}
