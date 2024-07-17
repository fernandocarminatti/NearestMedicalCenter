package com.nearestmedicalcenter.NearestMedicalCenter.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role(){}

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setRole(RoleName roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    @Override
    public String getAuthority() {
        return this.roleName.name();
    }

    public enum RoleName {
        ADMIN,
        MANAGER,
        NEWS_MANAGER,
        ASSOCIATE_MANAGER
    }

    public String toString(){
        return this.roleName.name();
    }
}
