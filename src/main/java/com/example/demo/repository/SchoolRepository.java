package com.example.demo.repository;

import com.example.demo.Domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchoolRepository extends CrudRepository<School, Integer>, JpaRepository<School, Integer>, PagingAndSortingRepository<School,Integer>, JpaSpecificationExecutor<School> {
}
