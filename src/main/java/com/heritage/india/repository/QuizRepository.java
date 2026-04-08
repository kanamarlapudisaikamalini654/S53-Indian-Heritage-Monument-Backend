package com.heritage.india.repository;


import com.heritage.india.entity.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<QuizResult, Long> {
    // No code needed! JpaRepository handles save(), findAll(), etc.
}