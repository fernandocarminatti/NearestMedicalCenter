package com.nearestmedicalcenter.NearestMedicalCenter.controller;

import com.nearestmedicalcenter.NearestMedicalCenter.model.ApplicationUser;
import com.nearestmedicalcenter.NearestMedicalCenter.model.dtos.ApplicationUserRegistrationDto;
import com.nearestmedicalcenter.NearestMedicalCenter.service.ApplicationUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/application-users")
public class ApplicationUserController {

    ApplicationUserService applicationUserService;

    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<ApplicationUser>> getApplicationUsers() {
        return ResponseEntity.ok(applicationUserService.getApplicationUsers());
    }

    @PostMapping()
    public void createApplicationUser(@RequestBody ApplicationUserRegistrationDto applicationUserRegistrationDto) {
        applicationUserService.createApplicationUser(applicationUserRegistrationDto);

    }

}
