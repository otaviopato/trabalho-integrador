package com.br.martial.arts.martial.arts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.martial.arts.martial.arts.model.Teacher;
import com.br.martial.arts.martial.arts.repository.TeacherRepository;


@RestController
@RequestMapping("/teachers")
public class TeacherController {
    
    @Autowired
    private final TeacherRepository teacherRepository;    

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    @GetMapping("/{id}")
    public Teacher teacher(@PathVariable("id") Long id){
      Optional<Teacher> teacherFind = this.teacherRepository.findById(id);
      if (teacherFind.isPresent()) {
        Teacher teacher = teacherFind.get();
        return teacher;}
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
      }

    @PostMapping("/")
    public Teacher teacher(@RequestBody Teacher teacher){
      return this.teacherRepository.save(teacher);
    }

    @GetMapping("/list")
    public List<Teacher> list(@RequestHeader(value = "Authorization", required = false) String authKey) {
      return this.teacherRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteEmployee(@PathVariable("id") Long id,
        @RequestHeader(value = "Authorization", required = false) String authKey) {
      Optional<Teacher> existsTeachers = this.teacherRepository.findById(id);
      if (existsTeachers.isPresent()) {
        this.teacherRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }

@PutMapping("/{id}")
public Teacher putUpdateEmployeeById(@PathVariable("id") Long id,
    @RequestBody Teacher fieldsToUpdate) {
  Optional<Teacher> employeeFind = this.teacherRepository.findById(id);
  if (employeeFind.isEmpty()) {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
  }
  fieldsToUpdate.setId(id);
  return this.teacherRepository.save(fieldsToUpdate);
}

@PatchMapping("/{id}")
public Teacher patchUpdateTeacherById(@PathVariable("id") Long id,
    @RequestBody Teacher fieldsToUpdate) {
  Optional<Teacher> teachersFind = this.teacherRepository.findById(id);
  if (teachersFind.isEmpty()) {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
  }
  Teacher teachers = teachersFind.get();
  fieldsToUpdate.setId(id);
  // Ugly code area
  fieldsToUpdate.setName(fieldsToUpdate.getName() == null ? teachers.getName() : fieldsToUpdate.getName());
  fieldsToUpdate.setEmail(fieldsToUpdate.getEmail() == null ? teachers.getEmail() : fieldsToUpdate.getEmail());
  fieldsToUpdate.setCpf(fieldsToUpdate.getCpf() == null ? teachers.getCpf() : fieldsToUpdate.getCpf());
  fieldsToUpdate.setPhone(fieldsToUpdate.getPhone() == null ? teachers.getPhone() : fieldsToUpdate.getPhone());
  fieldsToUpdate.setAddress(fieldsToUpdate.getAddress() == null ? teachers.getAddress() : fieldsToUpdate.getAddress());
  fieldsToUpdate.setBirthDate(fieldsToUpdate.getBirthDate() == null ? teachers.getBirthDate() : fieldsToUpdate.getBirthDate());
  // Ugly code area
  return this.teacherRepository.save(fieldsToUpdate);
}

}