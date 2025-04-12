package com.gerenciamento.consultas.mapper;

import com.gerenciamento.consultas.dto.AppointmentDTO;
import com.gerenciamento.consultas.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public static AppointmentDTO toDto(Appointment appointment){
        return AppointmentDTO.builder()
                .patientId( appointment.getPatient().getId() )
                .doctorId( appointment.getDoctor().getId() )
                .dateTime( appointment.getDateTime() )
                .status( appointment.getAppointmentStatus().toString() ).build();
    }
}
