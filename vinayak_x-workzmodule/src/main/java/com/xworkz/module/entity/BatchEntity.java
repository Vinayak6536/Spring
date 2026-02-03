package com.xworkz.module.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Component
@Entity
public class BatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int batchId;

    private String batchName;
    private String batchStartDate;
    private String batchEndDate;
    private String batchTrainer;

    // One Batch → Many Students
    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentEntity> students;

    // One Batch → One Logo
    @OneToOne(mappedBy = "batch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BatchLogoEntity batchLogo;
}
