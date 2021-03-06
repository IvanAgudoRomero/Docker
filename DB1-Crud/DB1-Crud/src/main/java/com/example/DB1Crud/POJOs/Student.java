package com.example.DB1Crud.POJOs;

import com.example.DB1Crud.DTOs.input.StudentInputDTO;
import com.example.DB1Crud.Repositorios.PersonaRepositorio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_student;
    @OneToOne
    @JoinColumn(name="id_persona")
    Persona persona;
    @Column(name="num_hours_week")
    Integer num_hours_week;
    @Column(name="coments")
    String coments;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_profesor")
    Profesor profesor;
    @Column(name="branch")
    String branch;
    @OneToMany
    List<Alumnos_Estudios> estudios;


    public Student(StudentInputDTO studentInputDTO) {
        setId_student(studentInputDTO.getId_student());
        setPersona(studentInputDTO.estudiante().persona);
        setNum_hours_week(studentInputDTO.getNum_hours_week());
        setComents(studentInputDTO.getComents());
        setProfesor(studentInputDTO.estudiante().profesor);
        setBranch(studentInputDTO.getBranch());
        setEstudios(studentInputDTO.getEstudios());
    }

    public Student() {
    }
}
