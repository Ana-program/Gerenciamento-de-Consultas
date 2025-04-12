package com.gerenciamento.consultas.entity;

import com.gerenciamento.consultas.util.Specialty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true)
    private String crm;

    @NotBlank @Column(unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @NotBlank @Column(unique = true)
    private String name;

    @NotBlank @Column(unique = true)
    private String email;

    @NotBlank @Column(unique = true)
    private String phone;
}
