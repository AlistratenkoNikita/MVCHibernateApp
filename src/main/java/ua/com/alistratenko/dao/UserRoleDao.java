package ua.com.alistratenko.dao;

import ua.com.alistratenko.entity.UserRole;

import java.util.List;

public interface UserRoleDao {

    void createRole(UserRole role);

    List<UserRole> listRoles();

    void updateRole(UserRole role);

    void deleteRole(UserRole role);

    UserRole getRoleByName(String name);

    UserRole getRoleById(String id);
}
