package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppRoleRepository extends JpaRepository<AppRole, UUID> {
    AppRole findByName(String name);
}
