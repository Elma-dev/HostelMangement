package com.pfe.hostelmangement.security;

import com.pfe.hostelmangement.dtos.UserDto;
import com.pfe.hostelmangement.entities.UserEntity;
import com.pfe.hostelmangement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final UserEntity userEntity = this.repository.findByUsername(username);
        if(userEntity == null) {
            throw new UsernameNotFoundException("Unknown user "+ username);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(String.valueOf(userEntity.getRole())) // Replace with appropriate roles from userEntity if available
                .build();
    }
}
