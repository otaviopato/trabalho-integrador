package com.br.martial.arts.martial.arts.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.br.martial.arts.martial.arts.model.Teacher;
import com.br.martial.arts.martial.arts.repository.TeacherRepository;

@Service
public class TeacherService implements UserDetailsService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Teacher teacher = teacherRepository.findByEmail(email);
        if (teacher == null) {
            //throw new UsernameNotFoundException("Teacher email not found");
            return null;
        }
        return User.builder()
                .username(teacher.getEmail())
                .password(teacher.getPassword())
                .roles("PROFESSOR")
                .build();
    }
}

