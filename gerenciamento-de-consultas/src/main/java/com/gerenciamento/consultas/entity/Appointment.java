package com.gerenciamento.consultas.entity;

import com.gerenciamento.consultas.util.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "appointment" )
public class Appointment {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @ManyToOne
    @JoinColumn( name = "medico_id" )
    private Doctor doctor;

    @ManyToOne
    @JoinColumn( name = "paciente_id" )
    private Patient patient;

    private LocalDateTime dateTime;

    @Enumerated( EnumType.STRING )
    private AppointmentStatus appointmentStatus;

    private String cancellationReason;
}
