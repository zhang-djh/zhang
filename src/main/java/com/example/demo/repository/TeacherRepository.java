package com.example.demo.repository;

import com.example.demo.Domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>, JpaRepository<Teacher, Integer>, PagingAndSortingRepository<Teacher,Integer>, JpaSpecificationExecutor<Teacher> {
}
