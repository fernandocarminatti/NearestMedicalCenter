package com.nearestmedicalcenter.NearestMedicalCenter.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_name", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Role(){}

    public Role(String roleName) {
        this.roleName = RoleName.valueOf(roleName);
    }

    public Long getRoleId() {
        return roleId;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public enum RoleName {
        ADMIN,
        MANAGER,
        NEWS_MANAGER,
        ASSOCIATE_MANAGER
    }
}
