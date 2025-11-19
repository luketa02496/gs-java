package com.lucas.work_well.repository;

import com.lucas.work_well.model.entity.DailyAssessment;
import com.lucas.work_well.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DailyAssessmentRepository extends JpaRepository<DailyAssessment, Long> {
    List<DailyAssessment> findByUser(User user);
    
    Page<DailyAssessment> findByUser(User user, Pageable pageable);
}
