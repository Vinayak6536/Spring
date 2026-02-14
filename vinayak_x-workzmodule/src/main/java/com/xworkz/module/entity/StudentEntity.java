package com.xworkz.module.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@ToString(exclude = "batch")
@Entity
@Component
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private long phone;

    private int age;

    private String gender;

    private String qualification;

    private String collegeName;

    private String address;

    private String joinedDate;

    private boolean active;

    // ✅ FK ID (used for insert/update)
    @Column(name = "batch_id", nullable = false)
    private int batchId;

    // ✅ Relation (read-only)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id", insertable = false, updatable = false)
    private BatchEntity batch;
}
