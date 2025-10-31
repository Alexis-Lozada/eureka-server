package com.example.dwi.ms_b.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EntityBEntityA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idEntityBId;
}
