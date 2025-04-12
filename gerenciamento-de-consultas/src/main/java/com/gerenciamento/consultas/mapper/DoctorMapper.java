package com.gerenciamento.consultas.mapper;

import com.gerenciamento.consultas.dto.DoctorDTO;
import com.gerenciamento.consultas.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public DoctorDTO toDto(Doctor doctor){
        return DoctorDTO.builder()
                .name( doctor.getName() )
                .email( doctor.getEmail() )
                .phone( doctor.getPhone() )
                .crm( doctor.getCrm() )
                .specialty( doctor.getSpecialty().toString() )
                .build();
    }
}
