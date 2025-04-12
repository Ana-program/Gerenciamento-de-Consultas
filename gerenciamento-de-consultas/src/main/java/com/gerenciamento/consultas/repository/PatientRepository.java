package com.gerenciamento.consultas.repository;

import com.gerenciamento.consultas.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long > {

    Optional<Patient> findById(Long id );
}
