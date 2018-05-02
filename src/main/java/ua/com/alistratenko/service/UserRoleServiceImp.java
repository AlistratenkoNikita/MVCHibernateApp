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
    public List<UserRole> getAllUserRoles() {
        return userRoleDao.allRoles();
    }
}
