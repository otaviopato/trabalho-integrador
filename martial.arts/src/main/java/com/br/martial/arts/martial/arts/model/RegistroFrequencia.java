package com.br.martial.arts.martial.arts.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
public class RegistroFrequencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //TODO verificar registro de frequencia

    @ManyToMany(mappedBy = "registros", fetch = FetchType.LAZY)
    private Set<Aulas> aulas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "registro_aluno",
                joinColumns = @JoinColumn(name="registro_fk"),
                inverseJoinColumns = @JoinColumn(name="aluno_fk"))
    private Set<Student> alunos;
}
