package com.itxxx.service;

import com.itxxx.domain.Permission;
import com.itxxx.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(String id);

    List<Permission> findOtherPermission(String id);

    void addRoleToUser(String roleId, String[] ids);
}
