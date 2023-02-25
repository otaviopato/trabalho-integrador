package com.br.martial.arts.martial.arts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.martial.arts.martial.arts.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>  {
    
}
