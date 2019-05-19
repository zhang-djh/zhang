package com.example.demo.repository;

import com.example.demo.Domain.SchoolCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentCourseRepository extends CrudRepository<SchoolCourse, Integer>, JpaRepository<SchoolCourse, Integer>, PagingAndSortingRepository<SchoolCourse,Integer>, JpaSpecificationExecutor<SchoolCourse> {
}
