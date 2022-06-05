package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    AppUser findByUserName(String username);
}
