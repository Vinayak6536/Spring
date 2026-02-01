package com.xworkz.module.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BatchLogoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logoId;

    private String logoName;
    private String logoType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] logoData;

    // FK owner
    @OneToOne
    @JoinColumn(name = "batch_id", unique = true)
    private BatchEntity batch;
}
