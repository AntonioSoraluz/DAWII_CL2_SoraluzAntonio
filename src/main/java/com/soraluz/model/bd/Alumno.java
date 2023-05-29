package com.soraluz.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idalumno;

    @Column(name = "apealumno")
    private String apealumno;

    @Column(name = "nomalumno")
    private String nomalumno;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialidad;

    @Column(name = "proce")
    private String proce;
}

