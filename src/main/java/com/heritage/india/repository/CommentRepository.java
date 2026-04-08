package com.heritage.india.repository;

import com.heritage.india.entity.Comment; // Or .entity.Comment depending on your folder
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // This finds comments for a specific monument
    List<Comment> findByMonumentId(Long monumentId);
}