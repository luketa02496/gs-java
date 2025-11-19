package com.lucas.work_well.service;

import com.lucas.work_well.model.dto.DailyAssessmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DailyAssessmentService {

    DailyAssessmentDTO create(DailyAssessmentDTO dto);

    Page<DailyAssessmentDTO> listByUser(Long userId, Pageable pageable);
}
