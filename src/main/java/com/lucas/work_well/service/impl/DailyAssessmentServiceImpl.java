package com.lucas.work_well.service.impl;

import com.lucas.work_well.mapper.DailyAssessmentMapper;
import com.lucas.work_well.model.dto.DailyAssessmentDTO;
import com.lucas.work_well.model.entity.DailyAssessment;
import com.lucas.work_well.model.entity.User;
import com.lucas.work_well.repository.DailyAssessmentRepository;
import com.lucas.work_well.repository.UserRepository;
import com.lucas.work_well.service.DailyAssessmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
@Transactional
public class DailyAssessmentServiceImpl implements DailyAssessmentService {

    private final DailyAssessmentRepository repo;
    private final UserRepository userRepo;
    private final DailyAssessmentMapper mapper;

    public DailyAssessmentServiceImpl(DailyAssessmentRepository repo, UserRepository userRepo, DailyAssessmentMapper mapper) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public DailyAssessmentDTO create(DailyAssessmentDTO dto) {
        User user = userRepo.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        DailyAssessment entity = mapper.toEntity(dto, user);
        entity.setData(LocalDate.now());
        DailyAssessment saved = repo.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Page<DailyAssessmentDTO> listByUser(Long userId, Pageable pageable) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        Page<DailyAssessment> page = repo.findByUser(user, pageable);
        return page.map(mapper::toDto);
    }
}
