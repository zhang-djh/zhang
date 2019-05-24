package com.example.demo.repository;

import com.example.demo.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer>, JpaRepository<Student, Integer>, PagingAndSortingRepository<Student,Integer>, JpaSpecificationExecutor<Student>
{
     Student findByStudentId(int id);
     List<Student> findByStudentIdAndAndName(int id, String name);
     List<Student> findByStudentIdAndPassword(int id,String passwd);
}
