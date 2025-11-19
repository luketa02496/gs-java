package com.lucas.work_well.config;

import com.lucas.work_well.model.entity.DailyAssessment;
import com.lucas.work_well.model.entity.User;
import com.lucas.work_well.repository.DailyAssessmentRepository;
import com.lucas.work_well.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DBInitializer {

    private final UserRepository userRepo;
    private final DailyAssessmentRepository assessmentRepo;
    private final PasswordEncoder passwordEncoder;

    public DBInitializer(UserRepository userRepo,
                         DailyAssessmentRepository assessmentRepo,
                         PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.assessmentRepo = assessmentRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (userRepo.count() == 0) {
            User admin = User.builder()
                    .nome("Administrador")
                    .email("admin@workwell.com")
                    .senha(passwordEncoder.encode("123456"))
                    .role("ROLE_ADMIN")
                    .build();

            User user = User.builder()
                    .nome("Lucas")
                    .email("lucas@workwell.com")
                    .senha(passwordEncoder.encode("654321"))
                    .role("ROLE_USER")
                    .build();

            User user1 = User.builder()
                    .nome("Marcella")
                    .email("marcella@workwell.com")
                    .senha(passwordEncoder.encode("abc123"))
                    .role("ROLE_ADMIN")
                    .build();

            userRepo.save(admin);
            userRepo.save(user);
            userRepo.save(user1);

            DailyAssessment a1 = DailyAssessment.builder()
                    .user(user)
                    .humor(4)
                    .estresse(2)
                    .produtividade(5)
                    .data(LocalDate.now())
                    .build();

            assessmentRepo.save(a1);

            System.out.println(">>> Banco H2 inicializado com dados padrão.");
        }
    }
}
