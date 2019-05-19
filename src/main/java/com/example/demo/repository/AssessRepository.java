package com.example.demo.repository;

import com.example.demo.Domain.Assess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AssessRepository extends CrudRepository<Assess, Integer>, JpaRepository<Assess, Integer>, PagingAndSortingRepository<Assess,Integer>, JpaSpecificationExecutor<Assess> {
}
