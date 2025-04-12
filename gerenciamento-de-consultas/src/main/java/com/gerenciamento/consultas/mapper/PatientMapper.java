package com.gerenciamento.consultas.mapper;

import com.gerenciamento.consultas.dto.PatientDTO;
import com.gerenciamento.consultas.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientDTO toDto(Patient patient){
        return PatientDTO.builder()
                .name( patient.getName() )
                .email( patient.getEmail() )
                .phone( patient.getPhone() )
                .build();
    }
}
