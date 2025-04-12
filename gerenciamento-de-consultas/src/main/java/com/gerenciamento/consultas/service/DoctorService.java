package com.gerenciamento.consultas.service;

import com.gerenciamento.consultas.dto.DoctorDTO;
import com.gerenciamento.consultas.entity.Doctor;
import com.gerenciamento.consultas.enumError.EnumError;
import com.gerenciamento.consultas.exception.CustomException;
import com.gerenciamento.consultas.mapper.DoctorMapper;
import com.gerenciamento.consultas.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    public Doctor registerDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<DoctorDTO> getHistoryByDoctor(Long id ){
        if (!doctorRepository.existsById(id)){
            throw new CustomException(EnumError.DOCTOR_NOT_FOUND);
        }
        Optional<Doctor> historico = doctorRepository.findById( id );
        return historico.stream().map(doctorMapper::toDto).collect(Collectors.toList());
    }

    public void deleteById(Long id ){
        if (!doctorRepository.existsById(id)){
            throw new CustomException(EnumError.DOCTOR_NOT_FOUND);
        }
        doctorRepository.deleteById( id );
    }

}
