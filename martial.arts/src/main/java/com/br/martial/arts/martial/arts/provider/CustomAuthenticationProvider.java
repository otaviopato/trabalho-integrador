package com.br.martial.arts.martial.arts.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.martial.arts.martial.arts.service.SecretariaService;
import com.br.martial.arts.martial.arts.service.TeacherService;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SecretariaService secretariaService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Authentication authTeacher = authenticateTeacher(username, password);
        if (authTeacher != null) {
            return authTeacher;
        }
        Authentication authSecretaria = authenticateSecretaria(username, password);
        if (authSecretaria != null) {
            return authSecretaria;
        }

        throw new BadCredentialsException("Invalid email or password");
    }

    private Authentication authenticateTeacher(String username, String password) throws AuthenticationException {
        UserDetails userDetails = teacherService.loadUserByUsername(username);
        if (userDetails == null) {
            System.out.println("userDetails");
            return null;
        }
        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        }
        throw new BadCredentialsException("Invalid email or password");
    }

    private Authentication authenticateSecretaria(String username, String password) throws AuthenticationException {
        UserDetails userDetails = secretariaService.loadUserByUsername(username);
        if (userDetails == null) {
            System.out.println("userDetails");
            return null;
        }
        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        }
        throw new BadCredentialsException("Invalid email or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}