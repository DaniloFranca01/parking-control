package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.AppRole;
import com.api.parkingcontrol.models.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser appUser);
    AppRole saveRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();

}
