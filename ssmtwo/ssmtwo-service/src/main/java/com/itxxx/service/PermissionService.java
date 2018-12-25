package com.itxxx.service;

import com.itxxx.domain.Permission;
import com.itxxx.domain.Role;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);

}
