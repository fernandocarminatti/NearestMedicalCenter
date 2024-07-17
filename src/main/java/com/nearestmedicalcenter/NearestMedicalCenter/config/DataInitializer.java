package com.nearestmedicalcenter.NearestMedicalCenter.config;

import com.nearestmedicalcenter.NearestMedicalCenter.model.ApplicationUser;
import com.nearestmedicalcenter.NearestMedicalCenter.model.Role;
import com.nearestmedicalcenter.NearestMedicalCenter.repository.ApplicationUserRepository;
import com.nearestmedicalcenter.NearestMedicalCenter.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    ApplicationUserRepository applicationUserRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    public DataInitializer(ApplicationUserRepository applicationUserRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder){
        this.applicationUserRepository = applicationUserRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if(applicationUserRepository.findByUsername("admin").isPresent() && roleRepository.findByRoleName("ADMIN").isPresent()){
            return;
        }

        Role adminRole = roleRepository.save(new Role("ADMIN"));
        Role managerRole = roleRepository.save(new Role("MANAGER"));
        Role associateRole = roleRepository.save(new Role("ASSOCIATE_MANAGER"));
        Role newsRole = roleRepository.save(new Role("NEWS_MANAGER"));

        ApplicationUser adminUser = applicationUserRepository.save(
                new ApplicationUser("admin",
                        "admin@admin.com",
                        passwordEncoder.encode("admin"),
                        Set.of(adminRole, managerRole)
                )
        );
    }
}
