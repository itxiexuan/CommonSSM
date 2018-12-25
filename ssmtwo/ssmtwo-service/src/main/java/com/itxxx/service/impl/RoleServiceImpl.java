package com.itxxx.service.impl;

import com.itxxx.dao.RoleDao;
import com.itxxx.domain.Permission;
import com.itxxx.domain.Role;
import com.itxxx.service.RoleService;
import com.sun.org.apache.xml.internal.utils.ListingErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        List<Role> list = roleDao.findAll();
        return list;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) {
        Role role = roleDao.findByRoleId(id);
        return role;
    }

    @Override
    public List<Permission> findOtherPermission(String id) {
        List<Permission> list = roleDao.findOtherPermission(id);
        return list;
    }

    @Override
    public void addRoleToUser(String roleId, String[] ids) {
        for (String permissionId : ids) {
            roleDao.addRoleToUser(permissionId,roleId);
        }
    }
}
