package com.pibox.um.service;

import com.pibox.um.domain.User;
import com.pibox.um.exception.domain.EmailExistException;
import com.pibox.um.exception.domain.UserNotFoundException;
import com.pibox.um.exception.domain.UsernameExistException;

import java.util.List;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, UsernameExistException, EmailExistException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
