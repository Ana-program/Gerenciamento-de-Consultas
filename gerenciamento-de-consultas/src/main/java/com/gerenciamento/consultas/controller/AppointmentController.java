package com.gerenciamento.consultas.controller;

import com.gerenciamento.consultas.entity.Appointment;
import com.gerenciamento.consultas.service.AppointmentService;
import com.gerenciamento.consultas.util.CancellationReason;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping("/schedule")
    public ResponseEntity<Appointment> scheduleAppointment(@RequestParam Long patientId,
                                                           @RequestParam Long doctorId,
                                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate appointmentDate) {
        Appointment appointment = service.scheduleAppointment(patientId, doctorId, appointmentDate.atStartOfDay());
        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
    }

    @DeleteMapping("{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId,
                                                  @RequestBody CancellationReason cancellationReason) {
        service.cancelAppointment(appointmentId, cancellationReason);
        return ResponseEntity.noContent().build();

    }
}
