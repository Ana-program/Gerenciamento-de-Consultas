package com.gerenciamento.consultas.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {


    private String name;
    private String email;
    private String phone;
    private String crm;
    private String specialty;

}
