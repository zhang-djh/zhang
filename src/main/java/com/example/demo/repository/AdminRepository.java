package com.example.demo.repository;

import com.example.demo.Domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer>, JpaRepository<Admin, Integer>, PagingAndSortingRepository<Admin,Integer>, JpaSpecificationExecutor<Admin> {
}
