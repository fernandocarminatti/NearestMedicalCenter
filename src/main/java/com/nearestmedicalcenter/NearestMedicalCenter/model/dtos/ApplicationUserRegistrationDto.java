package com.nearestmedicalcenter.NearestMedicalCenter.model.dtos;

import com.nearestmedicalcenter.NearestMedicalCenter.model.Role;

import java.util.Set;

public record ApplicationUserRegistrationDto(String username, String email, String password, String[] role) {
}
