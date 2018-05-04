package ua.com.alistratenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alistratenko.dao.UserRoleDao;
import ua.com.alistratenko.entity.UserRole;

import java.util.List;

@Service
@Transactional
public class UserRoleServiceImp implements UserRoleService {

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public void createNewUserRole(UserRole role) {
        userRoleDao.createRole(role);
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleDao.listRoles();
    }

    @Override
    public void updateUserRole(UserRole role) {
        userRoleDao.updateRole(role);
    }

    @Override
    public void deleteUserRole(UserRole role) {
        userRoleDao.deleteRole(role);
    }

    @Override
    public UserRole getUserRoleByName(String name) {
        return userRoleDao.getRoleByName(name);
    }

    @Override
    public UserRole getUserRoleById(String id) {
        return userRoleDao.getRoleById(id);
    }
}
