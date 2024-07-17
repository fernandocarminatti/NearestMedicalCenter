package com.nearestmedicalcenter.NearestMedicalCenter.repository;

import com.nearestmedicalcenter.NearestMedicalCenter.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByRoleName(Role.RoleName roleName);
}
