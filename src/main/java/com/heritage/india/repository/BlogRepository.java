package com.heritage.india.repository;

import com.heritage.india.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // JpaRepository gives you findAll() and save() out of the box!
}