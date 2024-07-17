package com.nearestmedicalcenter.NearestMedicalCenter.model;

import java.util.Set;

public record ApplicationUserRegistrationDto(String username, String email, String password, Set<Role> roles) {
}
