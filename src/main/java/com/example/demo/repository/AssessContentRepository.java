package com.example.demo.repository;

import com.example.demo.Domain.AssessContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AssessContentRepository extends CrudRepository<AssessContent, Integer>, JpaRepository<AssessContent, Integer>, PagingAndSortingRepository<AssessContent,Integer>, JpaSpecificationExecutor<AssessContent> {
    List<AssessContent> findByCourseId(int courseid);
    AssessContent findByAssesscontentId(int id);
}
