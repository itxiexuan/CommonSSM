package com.itxxx.service.impl;

import com.itxxx.dao.PermissionDao;
import com.itxxx.domain.Permission;
import com.itxxx.domain.Role;
import com.itxxx.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao pd;
    @Override
    public List<Permission> findAll() {
        List<Permission> list = pd.findAll();
        return list;
    }

    @Override
    public void save(Permission permission) {
        pd.save(permission);
    }
}
