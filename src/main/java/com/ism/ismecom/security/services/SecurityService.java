package com.ism.ismecom.security.services;

import com.ism.ismecom.security.data.entities.AppRole;
import com.ism.ismecom.security.data.entities.AppUser;

public interface SecurityService {
    AppUser getUser(String username);
    AppUser saveUser(String username, String password);
    AppRole saveRole(String roleName);
    void addRoleToUser(String username,String roleName);
    void removeRoleToUser(String username,String roleName);

}
