package io.aou.zenicor.service;

import io.aou.zenicor.model.User;

import java.util.Optional;



public interface UserService {

    Optional<User> findUserByCredentials(String name, String password);

}
