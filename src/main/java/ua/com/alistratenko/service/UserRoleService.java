package ua.com.alistratenko.service;

import ua.com.alistratenko.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    void createNewUserRole(UserRole role);

    List<UserRole> getAllUserRoles();

    void updateUserRole(UserRole role);

    void deleteUserRole(UserRole role);

    UserRole getUserRoleByName(String name);

    UserRole getUserRoleById(String id);

}
