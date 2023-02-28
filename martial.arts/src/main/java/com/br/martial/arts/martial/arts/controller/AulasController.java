package com.br.martial.arts.martial.arts.controller;

import com.br.martial.arts.martial.arts.model.Aulas;
import com.br.martial.arts.martial.arts.repository.AulasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulasController {

    @Autowired
    private AulasRepository aulasRepository;

    @GetMapping("/aulas")
    public List<Aulas> getAllAulas() {
        return aulasRepository.findAll();
    }

    @PostMapping("/aulas")
    public Aulas createAulas(@RequestBody Aulas aulas) {
        return aulasRepository.save(aulas);
    }

    @GetMapping("/aulas/{id}")
    public Aulas getAulasById(@PathVariable(value = "id") Long id) {
        return aulasRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada"));
    }

    @PutMapping("/aulas/{id}")
    public Aulas updateAulas(@PathVariable(value = "id") Long id,
                           @RequestBody Aulas aulasDetails) {

        Aulas aulas = aulasRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada"));

        aulas.setName(aulasDetails.getName());

        Aulas updatedAulas = aulasRepository.save(aulas);
        return updatedAulas;
    }

    @DeleteMapping("/aulas/{id}")
    public ResponseEntity<?> deleteAulas(@PathVariable(value = "id") Long id) {
        Aulas aulas = aulasRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada"));

        aulasRepository.delete(aulas);

        return ResponseEntity.ok().build();
    }
}