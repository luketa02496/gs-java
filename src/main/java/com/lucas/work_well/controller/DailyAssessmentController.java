package com.lucas.work_well.controller;

import com.lucas.work_well.model.dto.DailyAssessmentDTO;
import com.lucas.work_well.service.DailyAssessmentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/daily")
public class DailyAssessmentController {

    private final DailyAssessmentService svc;

    public DailyAssessmentController(DailyAssessmentService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<DailyAssessmentDTO> create(@Valid @RequestBody DailyAssessmentDTO dto) {
        DailyAssessmentDTO created = svc.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Page<DailyAssessmentDTO>> listByUser(@PathVariable Long userId, Pageable pageable) {
        Page<DailyAssessmentDTO> page = svc.listByUser(userId, pageable);
        return ResponseEntity.ok(page);
    }
}
