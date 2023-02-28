package com.br.martial.arts.martial.arts.service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.martial.arts.martial.arts.model.Secretaria;
import com.br.martial.arts.martial.arts.repository.SecretariaRepository;

@Service
public class SecretariaService implements UserDetailsService {
    @Autowired
    private SecretariaRepository secretariaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Secretaria secretaria = secretariaRepository.findByEmail(email);
        if (secretaria == null) {
            return null;
        }
        return User.builder()
                .username(secretaria.getEmail())
                .password(secretaria.getPassword())
                .roles("SECRETARIA")
                .build();
    }
}
