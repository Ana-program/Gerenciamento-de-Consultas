package com.gerenciamento.consultas.repository;

import com.gerenciamento.consultas.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long > {

    Optional<Doctor> findById(Long id );

}
