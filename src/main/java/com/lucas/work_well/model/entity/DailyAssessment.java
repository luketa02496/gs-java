package com.lucas.work_well.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "daily_assessment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int humor;
    private int estresse;
    private int produtividade;

    private LocalDate data = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
