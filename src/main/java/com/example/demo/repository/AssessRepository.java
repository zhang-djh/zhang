package com.example.demo.repository;

import com.example.demo.Domain.Assess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AssessRepository extends CrudRepository<Assess, Integer>, JpaRepository<Assess, Integer>, PagingAndSortingRepository<Assess,Integer>, JpaSpecificationExecutor<Assess> {
    List<Assess> findByAssesscontentIdAndAndBeassessIdAndAssesserId(int acid,int baid,int assid);
    List<Assess> findByAssesscontentId(int assesscontid);
    Assess findByAssessId(int assessid);

    List<Assess> findByBeassessId(int stuid);

    List<Assess> findByAssesserIdAndBeassessId(int assesserid,int beassessid);
}
