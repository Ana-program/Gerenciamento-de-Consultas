package com.gerenciamento.consultas.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PatientDTO {

    private String name;
    private String email;
    private String phone;

}
