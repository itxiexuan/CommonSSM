package com.itxxx.service;

import com.itxxx.domain.Role;
import com.itxxx.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void saveUser(UserInfo user);

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRole(String id);

    void addRoleToUser(String userId, String[] ids);
}
