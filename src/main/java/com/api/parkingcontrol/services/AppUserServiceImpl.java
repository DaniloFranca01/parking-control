package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.AppRole;
import com.api.parkingcontrol.models.AppUser;
import com.api.parkingcontrol.repositories.AppRoleRepository;
import com.api.parkingcontrol.repositories.AppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole saveRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUserName(username);
        AppRole appRole = appRoleRepository.findByName(roleName);
        appUser.getRoles().add(appRole);
    }

    @Override
    public AppUser getUser(String username) {
        return appUserRepository.findByUserName(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }
}
