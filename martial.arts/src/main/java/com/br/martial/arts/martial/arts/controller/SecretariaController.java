package com.br.martial.arts.martial.arts.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

import com.br.martial.arts.martial.arts.DTO.LoginResponse;
import com.br.martial.arts.martial.arts.model.Secretaria;
import com.br.martial.arts.martial.arts.repository.SecretariaRepository;


@RestController
@RequestMapping("/secretaria")
public class SecretariaController {

    @Autowired
    private final SecretariaRepository secretariaRepository;

    public SecretariaController(SecretariaRepository secretariaRepository) {
        this.secretariaRepository = secretariaRepository;
    }

    @GetMapping("/{id}")
    public Secretaria secretaria(@PathVariable("id") Long id) {
        Optional<Secretaria> secretariaFind = this.secretariaRepository.findById(id);
        if (secretariaFind.isPresent()) {
            Secretaria secretaria = secretariaFind.get();
            return secretaria;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }

    @PostMapping("/")
    public Secretaria secretaria(@RequestBody Secretaria secretaria) {
      return this.secretariaRepository.save(secretaria);
    }

    @GetMapping("/list")
    public List<Secretaria> list(@RequestHeader(value = "Authorization", required = false) String authKey) {
        return this.secretariaRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteSecretaria(@PathVariable("id") Long id,
            @RequestHeader(value = "Authorization", required = false) String authKey) {
        Optional<Secretaria> existsSecretarias = this.secretariaRepository.findById(id);
        if (existsSecretarias.isPresent()) {
            this.secretariaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }
    @PutMapping("/{id}")
    public Secretaria putUpdateEmployeeById(@PathVariable("id") Long id,
        @RequestBody Secretaria fieldsToUpdate) {
      Optional<Secretaria> employeeFind = this.secretariaRepository.findById(id);
      if (employeeFind.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
      }
      fieldsToUpdate.setId(id);
      return this.secretariaRepository.save(fieldsToUpdate);
    }
   
    @PatchMapping("/{id}")
    public Secretaria patchUpdateSecretariaById(@PathVariable("id") Long id,
        @RequestBody Secretaria fieldsToUpdate) {
      Optional<Secretaria> secretariaFind = this.secretariaRepository.findById(id);
      if (secretariaFind.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
      }
      Secretaria secretaria = secretariaFind.get();
      fieldsToUpdate.setId(id);
      fieldsToUpdate.setName(fieldsToUpdate.getName() == null ? secretaria.getName() : fieldsToUpdate.getName());
      fieldsToUpdate.setEmail(fieldsToUpdate.getEmail() == null ? secretaria.getEmail() : fieldsToUpdate.getEmail());
      fieldsToUpdate.setCpf(fieldsToUpdate.getCpf() == null ? secretaria.getCpf() : fieldsToUpdate.getCpf());
      fieldsToUpdate.setPhone(fieldsToUpdate.getPhone() == null ? secretaria.getPhone() : fieldsToUpdate.getPhone());
      fieldsToUpdate.setAddress(fieldsToUpdate.getAddress() == null ? secretaria.getAddress() : fieldsToUpdate.getAddress());
      fieldsToUpdate.setBirthDate(fieldsToUpdate.getBirthDate() == null ? secretaria.getBirthDate() : fieldsToUpdate.getBirthDate());
      return this.secretariaRepository.save(fieldsToUpdate);
    }
   
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Map<String, String> request, HttpSession session) {
    
        String email = request.get("email");
        String password = request.get("password");
    
        Secretaria secretaria = secretariaRepository.findByEmail(email);
    
        if (secretaria != null && BCrypt.checkpw(password, secretaria.getPassword())) {
         session.setAttribute("secretaria", secretaria);
   
         LoginResponse response = new LoginResponse();
         //response.setAuthToken("token"); // substitua "token" pelo valor do token gerado
         response.setUsername(secretaria.getEmail());
   
         return ResponseEntity.ok(response);
     } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
     }
   }
     @GetMapping("/logout")
     public String logout(HttpSession session) {
       session.invalidate();
       return "redirect:/login";
     }
        
}