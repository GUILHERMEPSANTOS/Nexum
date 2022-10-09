package com.nexum.backend.security.service;

import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.repositories.controle.acesso.SpringUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SpringUserRepository springUserRepository;

    public UserDetailsServiceImpl(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = springUserRepository.findByNome(username)
                .orElseThrow();

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        userEntity.getRoles().forEach(role -> authorities.add(
                new SimpleGrantedAuthority(role.getRoleName().toString()))
        );

        return new User(userEntity.getNome(), userEntity.getSenha(), authorities);
    }
}
