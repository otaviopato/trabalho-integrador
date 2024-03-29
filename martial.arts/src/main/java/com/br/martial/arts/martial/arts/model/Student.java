package com.br.martial.arts.martial.arts.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  @Column(unique=true)
  private String email;
  @Column(unique=true)
  private String cpf;
  private String phone;
  private String address;
  @JsonFormat(pattern = "dd-MM-yyyy")
  private Date birthDate;
  @Column(unique=true)
  private String matricula;
}
