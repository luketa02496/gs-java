package com.lucas.work_well.mapper;

import com.lucas.work_well.model.dto.DailyAssessmentDTO;
import com.lucas.work_well.model.entity.DailyAssessment;
import com.lucas.work_well.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DailyAssessmentMapper {

    public DailyAssessment toEntity(DailyAssessmentDTO dto, User user) {
        if (dto == null) return null;
        return DailyAssessment.builder()
                .id(dto.getId())
                .humor(dto.getHumor())
                .estresse(dto.getEstresse())
                .produtividade(dto.getProdutividade())
                .user(user)
                .build();
    }

    public DailyAssessmentDTO toDto(DailyAssessment entity) {
        if (entity == null) return null;
        DailyAssessmentDTO dto = new DailyAssessmentDTO();
        dto.setId(entity.getId());
        dto.setHumor(entity.getHumor());
        dto.setEstresse(entity.getEstresse());
        dto.setProdutividade(entity.getProdutividade());
        dto.setUserId(entity.getUser() != null ? entity.getUser().getId() : null);
        return dto;
    }
}
