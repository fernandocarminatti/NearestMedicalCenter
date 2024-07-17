package com.nearestmedicalcenter.NearestMedicalCenter.service;

import com.nearestmedicalcenter.NearestMedicalCenter.model.ApplicationUser;
import com.nearestmedicalcenter.NearestMedicalCenter.model.ApplicationUserRegistrationDto;
import com.nearestmedicalcenter.NearestMedicalCenter.repository.ApplicationUserRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {
    ApplicationUserRepository applicationUserRepository;

    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public void createApplicationUser(ApplicationUserRegistrationDto applicationUserRegistrationDto) {
        System.out.println("Service -> applicationUserRegistrationDto = " + applicationUserRegistrationDto);
        applicationUserRepository.save(new ApplicationUser(
                applicationUserRegistrationDto.username(),
                applicationUserRegistrationDto.email(),
                applicationUserRegistrationDto.password(),
                applicationUserRegistrationDto.roles()
                )
        );
    }
}
