package com.nearestmedicalcenter.NearestMedicalCenter.controller;

import com.nearestmedicalcenter.NearestMedicalCenter.model.ApplicationUserRegistrationDto;
import com.nearestmedicalcenter.NearestMedicalCenter.service.ApplicationUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/application-users")
public class ApplicationUserController {

    ApplicationUserService applicationUserService;

    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @PostMapping()
    public void createApplicationUser(@RequestBody ApplicationUserRegistrationDto applicationUserRegistrationDto) {
        System.out.println("Controller -> applicationUserRegistrationDto = " + applicationUserRegistrationDto);
        applicationUserService.createApplicationUser(applicationUserRegistrationDto);

    }

}
