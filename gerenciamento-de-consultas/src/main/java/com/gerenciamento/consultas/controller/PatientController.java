package com.gerenciamento.consultas.controller;

import com.gerenciamento.consultas.dto.PatientDTO;
import com.gerenciamento.consultas.entity.Patient;
import com.gerenciamento.consultas.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<Patient> register(@RequestBody @Valid Patient patient){
        Patient cadastrar = patientService.cadastrarPaciente(patient);
        return ResponseEntity.ok(cadastrar);
    }
    @GetMapping("/history/{patientId}")
    public ResponseEntity<List<PatientDTO>> patientHistory(@PathVariable Long patientId) {
        List<PatientDTO> history = patientService.findById(patientId);
        return ResponseEntity.ok(history );
    }
    @DeleteMapping("{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientId){
        patientService.deleteById(patientId);
        return ResponseEntity.noContent().build();
    }
}
