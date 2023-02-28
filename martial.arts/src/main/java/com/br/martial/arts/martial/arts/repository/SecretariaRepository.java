package com.br.martial.arts.martial.arts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.martial.arts.martial.arts.model.Secretaria;

public interface SecretariaRepository extends JpaRepository<Secretaria, Long>{
    Secretaria findByEmail(String email);
}
