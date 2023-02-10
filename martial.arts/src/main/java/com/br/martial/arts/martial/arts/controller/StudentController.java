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

import com.br.martial.arts.martial.arts.model.Student;
import com.br.martial.arts.martial.arts.repository.StudentRepository;


@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private final StudentRepository studentRepository;    

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping("/{id}")
    public Student student(@PathVariable("id") Long id){
      Optional<Student> studentFind = this.studentRepository.findById(id);
      if (studentFind.isPresent()) {
        Student student = studentFind.get();
        return student;}
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
      }

    @PostMapping("/")
    public Student student(@RequestBody Student student){
      return this.studentRepository.save(student);
    }

    @GetMapping("/list")
    public List<Student> list(@RequestHeader(value = "Authorization", required = false) String authKey) {
      return this.studentRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteEmployee(@PathVariable("id") Long id,
        @RequestHeader(value = "Authorization", required = false) String authKey) {
      Optional<Student> existsStudents = this.studentRepository.findById(id);
      if (existsStudents.isPresent()) {
        this.studentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }

@PutMapping("/{id}")
public Student putUpdateEmployeeById(@PathVariable("id") Long id,
    @RequestBody Student fieldsToUpdate) {
  Optional<Student> employeeFind = this.studentRepository.findById(id);
  if (employeeFind.isEmpty()) {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
  }
  fieldsToUpdate.setId(id);
  return this.studentRepository.save(fieldsToUpdate);
}

@PatchMapping("/{id}")
public Student patchUpdateStudentById(@PathVariable("id") Long id,
    @RequestBody Student fieldsToUpdate) {
  Optional<Student> studentsFind = this.studentRepository.findById(id);
  if (studentsFind.isEmpty()) {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
  }
  Student students = studentsFind.get();
  fieldsToUpdate.setId(id);
  // Ugly code area
  fieldsToUpdate.setName(fieldsToUpdate.getName() == null ? students.getName() : fieldsToUpdate.getName());
  fieldsToUpdate.setEmail(fieldsToUpdate.getEmail() == null ? students.getEmail() : fieldsToUpdate.getEmail());
  fieldsToUpdate.setCpf(fieldsToUpdate.getCpf() == null ? students.getCpf() : fieldsToUpdate.getCpf());
  fieldsToUpdate.setPhone(fieldsToUpdate.getPhone() == null ? students.getPhone() : fieldsToUpdate.getPhone());
  fieldsToUpdate.setAddress(fieldsToUpdate.getAddress() == null ? students.getAddress() : fieldsToUpdate.getAddress());
  fieldsToUpdate.setBirthDate(fieldsToUpdate.getBirthDate() == null ? students.getBirthDate() : fieldsToUpdate.getBirthDate());
  // Ugly code area
  return this.studentRepository.save(fieldsToUpdate);
}

}