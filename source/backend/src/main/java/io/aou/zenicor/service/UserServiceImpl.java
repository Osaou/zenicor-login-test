package io.aou.zenicor.service;

import io.aou.zenicor.dao.UserDAO;
import io.aou.zenicor.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public Optional<User> findUserByCredentials(String name, String password) {
        return userDAO
                .listUsers()
                .stream()
                .filter(u -> name.equalsIgnoreCase(u.getName()) && password.equals(u.getPassword()))
                .findFirst();
    }

}
