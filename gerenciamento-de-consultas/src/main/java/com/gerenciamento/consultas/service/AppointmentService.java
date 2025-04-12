package com.gerenciamento.consultas.service;

import com.gerenciamento.consultas.entity.Appointment;
import com.gerenciamento.consultas.entity.Doctor;
import com.gerenciamento.consultas.entity.Patient;
import com.gerenciamento.consultas.exception.AppointmentException;
import com.gerenciamento.consultas.repository.AppointmentRepository;
import com.gerenciamento.consultas.repository.DoctorRepository;
import com.gerenciamento.consultas.repository.PatientRepository;
import com.gerenciamento.consultas.util.CancellationReason;
import com.gerenciamento.consultas.util.AppointmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Appointment scheduleAppointment(Long patientId, Long doctorId, LocalDateTime dateTime ) {

        Doctor doctor = doctorRepository.findById( doctorId )
                .orElseThrow( () -> new AppointmentException( "Doctor not found!" ) );

        Patient patient = patientRepository.findById( patientId )
                .orElseThrow( () -> new AppointmentException( "Patient not found!" ) );

        boolean hasConflict = appointmentRepository.existsByDoctorAndDateTime(doctor, dateTime );
        if ( hasConflict ) {
            throw new AppointmentException( "There is already an appointment scheduled for this doctor at this time!" );
        }

        var appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setDateTime( dateTime );
        appointment.setAppointmentStatus( AppointmentStatus.SCHEDULED);

        return appointmentRepository.save( appointment );
    }

    public Appointment cancelAppointment(Long appointmentId, CancellationReason reason ) {
        Appointment appointment = appointmentRepository.findById( appointmentId )
                .orElseThrow( () -> new AppointmentException( "Appointment not found" ) );

        if ( appointment.getAppointmentStatus() == AppointmentStatus.CANCELED) {
            throw new AppointmentException( "This appointment has already been canceled!" );
        }

        appointment.setAppointmentStatus( AppointmentStatus.CANCELED);
        appointment.setCancellationReason(String.valueOf(reason));

        return appointmentRepository.save(appointment);
    }

}
