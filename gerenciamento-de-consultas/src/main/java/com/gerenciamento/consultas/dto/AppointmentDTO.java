package com.gerenciamento.consultas.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class AppointmentDTO {

    private Long doctorId;
    private Long patientId;
    private LocalDateTime dateTime;
    private String status;

}
