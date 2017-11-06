package com.yuhui.spring.feedback.repository;

import com.yuhui.spring.feedback.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, String> {
}
