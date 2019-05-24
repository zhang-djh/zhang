package com.example.demo.repository;

import com.example.demo.Domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ParentRepository extends CrudRepository<Parent, Integer>, JpaRepository<Parent, Integer>, PagingAndSortingRepository<Parent,Integer>, JpaSpecificationExecutor<Parent> {
    Parent findByStudentId(int id);
    Parent findByParentId(int id);
    List<Parent> findByParentIdAndParentName(int parid, String parname);
    List<Parent> findByParentIdAndPassword(int id,String passwd);
}
