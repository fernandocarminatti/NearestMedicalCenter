package com.nearestmedicalcenter.NearestMedicalCenter.repository;

import com.nearestmedicalcenter.NearestMedicalCenter.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {

    Optional<ApplicationUser> findByUsername(String username);
}
