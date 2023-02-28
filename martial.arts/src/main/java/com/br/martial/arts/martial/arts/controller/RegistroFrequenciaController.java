package com.br.martial.arts.martial.arts.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.br.martial.arts.martial.arts.model.RegistroFrequencia;
import com.br.martial.arts.martial.arts.model.Student;
import com.br.martial.arts.martial.arts.repository.RegistroFrequenciaRepository;
import com.br.martial.arts.martial.arts.repository.StudentRepository;

@RestController
@RequestMapping("/registrofrequencia")
public class RegistroFrequenciaController {

    @Autowired
    RegistroFrequenciaRepository registroFrequenciaRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/registrofrequencia")
    public List<RegistroFrequencia> getAllRegistroFrequencia() {
        return registroFrequenciaRepository.findAll();
    }

    @GetMapping("/registrofrequencia/{id}")
    public ResponseEntity<RegistroFrequencia> getRegistroFrequenciaById(
            @PathVariable(value = "id") Long registroFrequenciaId) {
        try {
            RegistroFrequencia registroFrequencia = registroFrequenciaRepository.findById(registroFrequenciaId).get();
            return ResponseEntity.ok().body(registroFrequencia);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro de frequência não encontrado", e);
        }
    }

    @PostMapping("/registrofrequencia")
    public RegistroFrequencia createRegistroFrequencia(@Valid @RequestBody RegistroFrequencia registroFrequencia) {
        return registroFrequenciaRepository.save(registroFrequencia);
    }

    @PutMapping("/registrofrequencia/{id}")
    public ResponseEntity<RegistroFrequencia> updateRegistroFrequencia(
            @PathVariable(value = "id") Long registroFrequenciaId,
            @RequestBody RegistroFrequencia registroFrequenciaDetails) {
        try {
            RegistroFrequencia registroFrequencia = registroFrequenciaRepository.findById(registroFrequenciaId).get();

            registroFrequencia.setAulas(registroFrequenciaDetails.getAulas());
            registroFrequencia.setAlunos(registroFrequenciaDetails.getAlunos());

            RegistroFrequencia updatedRegistroFrequencia = registroFrequenciaRepository.save(registroFrequencia);
            return ResponseEntity.ok(updatedRegistroFrequencia);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro de frequência não encontrado", e);
        }
    }

    @DeleteMapping("/registrofrequencia/{id}")
    public ResponseEntity<HttpStatus> deleteRegistroFrequencia(@PathVariable(value = "id") Long registroFrequenciaId) {
        try {
            RegistroFrequencia registroFrequencia = registroFrequenciaRepository.findById(registroFrequenciaId).get();
            registroFrequenciaRepository.delete(registroFrequencia);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Registro de frequência não encontrado", e);
        }
    }

    @PostMapping("/registrofrequencia/{idRegistroFrequencia}/aluno/{idAluno}")
    public ResponseEntity<HttpStatus> addStudentToRegistroFrequencia(
            @PathVariable(value = "idRegistroFrequencia") Long registroFrequenciaId,
            @PathVariable(value = "idAluno") Long alunoId) {
        try {
            RegistroFrequencia registroFrequencia = registroFrequenciaRepository.findById(registroFrequenciaId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Registro de Frequência não encontrado com o id: " + registroFrequenciaId));
            Student aluno = studentRepository.findById(alunoId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Aluno não encontrado com o id: " + alunoId));
            registroFrequencia.getAlunos().add(aluno);
            registroFrequenciaRepository.save(registroFrequencia);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao adicionar aluno ao registro de frequência", e);
        }
    }
}