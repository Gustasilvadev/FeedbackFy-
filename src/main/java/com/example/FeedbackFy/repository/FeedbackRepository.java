package com.example.FeedbackFy.repository;

import com.example.FeedbackFy.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    @Query("SELECT COUNT(f) FROM Feedback f")
    Integer countTotalFeedbacks();

    @Query("SELECT f.tipo, COUNT(f) FROM Feedback f GROUP BY f.tipo")
    List<Object[]> countFeedbacksByType();

}
