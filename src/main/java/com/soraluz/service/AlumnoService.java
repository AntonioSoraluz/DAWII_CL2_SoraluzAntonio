package com.soraluz.service;

import com.soraluz.model.bd.Alumno;
import com.soraluz.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos() {return alumnoRepository.findAll();}
    public void registrarAlumno(Alumno alumno) {alumnoRepository.save(alumno);}
    public void eliminarAlumno(Integer IdAlumno) {alumnoRepository.deleteById(IdAlumno);}
}
