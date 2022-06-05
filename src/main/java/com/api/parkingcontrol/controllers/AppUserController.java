package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.models.AppRole;
import com.api.parkingcontrol.models.AppUser;
import com.api.parkingcontrol.services.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getUsers(){
        return  ResponseEntity.ok().body(appUserService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser>saveUser(@RequestBody AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveUser(appUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<AppRole>saveRole(@RequestBody AppRole appRole){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(appRole));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        appUserService.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

class RoleToUserForm {
    private String userName;
    private String roleName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
