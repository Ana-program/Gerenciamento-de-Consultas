package com.gerenciamento.consultas.service;

import com.gerenciamento.consultas.dto.PatientDTO;
import com.gerenciamento.consultas.entity.Patient;
import com.gerenciamento.consultas.enumError.EnumError;
import com.gerenciamento.consultas.exception.CustomException;
import com.gerenciamento.consultas.mapper.PatientMapper;
import com.gerenciamento.consultas.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    public Patient cadastrarPaciente(Patient patient){
        return patientRepository.save(patient);
    }

    public List<PatientDTO> findById(Long id ){
        if (!patientRepository.existsById(id)){
            throw new CustomException(EnumError.PATIENT_NOT_FOUND);
        }
        Optional<Patient> getPaciente = patientRepository.findById( id );
        return getPaciente.stream().map(patientMapper::toDto).collect(Collectors.toList());
    }

    public void deleteById(Long id ){
        patientRepository.deleteById( id );
    }

}
