package com.nearestmedicalcenter.NearestMedicalCenter.service;

import com.nearestmedicalcenter.NearestMedicalCenter.model.ApplicationUser;
import com.nearestmedicalcenter.NearestMedicalCenter.model.Role;
import com.nearestmedicalcenter.NearestMedicalCenter.model.dtos.ApplicationUserRegistrationDto;
import com.nearestmedicalcenter.NearestMedicalCenter.repository.ApplicationUserRepository;
import com.nearestmedicalcenter.NearestMedicalCenter.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ApplicationUserService {
    ApplicationUserRepository applicationUserRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    public ApplicationUserService(ApplicationUserRepository applicationUserRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void createApplicationUser(ApplicationUserRegistrationDto applicationUserRegistrationDto) {
        ApplicationUser applicationUser = new ApplicationUser();

        applicationUser.setUsername(applicationUserRegistrationDto.username());
        applicationUser.setEmail(applicationUserRegistrationDto.email());
        applicationUser.setPassword(passwordEncoder.encode(applicationUserRegistrationDto.password()));
        applicationUser.setRoles(parseRoles(applicationUserRegistrationDto.role()));

        applicationUserRepository.save(applicationUser);
    }

    public Iterable<ApplicationUser> getApplicationUsers() {
        return applicationUserRepository.findAll();
    }

    public Set<Role> parseRoles(String[] roles){
        Set<Role> parsedRoles = new HashSet<>();
        for(String role: roles) {
            Optional<Role> roleOptional = roleRepository.findByRoleName(Role.RoleName.valueOf(role.toUpperCase()));
            roleOptional.ifPresent(parsedRoles::add);
        }
        return parsedRoles;
    }
}
