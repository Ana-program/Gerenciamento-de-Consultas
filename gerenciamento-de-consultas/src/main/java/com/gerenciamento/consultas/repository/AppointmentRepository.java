package com.gerenciamento.consultas.repository;

import com.gerenciamento.consultas.entity.Appointment;
import com.gerenciamento.consultas.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long > {

    boolean existsByDoctorAndDateTime(Doctor doctor, LocalDateTime dateTime );




}
