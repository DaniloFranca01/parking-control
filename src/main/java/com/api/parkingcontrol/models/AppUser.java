package com.api.parkingcontrol.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    private String name;
    private String username;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();

    public AppUser() {
    }

    public AppUser(UUID id, String name, String username, Collection<AppRole> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
}
