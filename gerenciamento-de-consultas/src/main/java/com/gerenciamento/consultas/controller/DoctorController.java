package com.gerenciamento.consultas.controller;

import com.gerenciamento.consultas.dto.DoctorDTO;
import com.gerenciamento.consultas.entity.Doctor;
import com.gerenciamento.consultas.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/register")
    public ResponseEntity<Doctor> registerDoctor(@RequestBody @Valid Doctor doctor){
        Doctor registeredDoctor = doctorService.registerDoctor(doctor);
        return ResponseEntity.ok(registeredDoctor);
    }

    @GetMapping("/history/{doctorId}")
    public ResponseEntity<List<DoctorDTO>> doctorHistory(@PathVariable Long doctorId ) {
        List<DoctorDTO> history = doctorService.getHistoryByDoctor( doctorId );
        return ResponseEntity.ok(history);
    }

    @DeleteMapping("/delete/{doctorId}")
    public ResponseEntity<DoctorDTO> deleteDoctor(@PathVariable Long doctorId ){
        doctorService.deleteById( doctorId );
        return ResponseEntity.noContent().build();
    }
}
