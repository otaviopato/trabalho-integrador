package com.br.martial.arts.martial.arts.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.martial.arts.martial.arts.controller.AulasController;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @JsonFormat(pattern = "HH:mm")
    private LocalDateTime horas;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data;
 
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable=false)
    private Teacher professor;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable=false)
    private Aulas aula;

    @ManyToMany
    @JoinTable(name = "turma_aluno",
                joinColumns = @JoinColumn(name="turma_fk"),
                inverseJoinColumns = @JoinColumn(name="aluno_fk"))
    private Set<Student> alunos;
}