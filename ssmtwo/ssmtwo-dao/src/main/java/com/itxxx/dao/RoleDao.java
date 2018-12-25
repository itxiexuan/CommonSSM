package com.itxxx.dao;

import com.itxxx.domain.Permission;
import com.itxxx.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId = #{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType =java.util.List.class,many = @Many(select = "com.itxxx.dao.PermissionDao.findById"))
    })
    List<Role> findById(String id);


    @Select("select * from role")
    List<Role> findAll();


    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findOtherPermission(String id);


    @Insert("insert into role_permission(permissionId,roleId) values(#{permissionId},#{roleId})")
    void addRoleToUser(@Param("permissionId") String permissionId, @Param("roleId") String roleId);


    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType =java.util.List.class,many = @Many(select = "com.itxxx.dao.PermissionDao.findById"))
    })
    Role findByRoleId(String id);
}
