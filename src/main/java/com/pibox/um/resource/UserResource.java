package com.pibox.um.resource;

import com.pibox.um.domain.User;
import com.pibox.um.exception.ExceptionHandling;
import com.pibox.um.exception.domain.EmailExistException;
import com.pibox.um.exception.domain.UserNotFoundException;
import com.pibox.um.exception.domain.UsernameExistException;
import com.pibox.um.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/user", "/"})
public class UserResource extends ExceptionHandling {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws UserNotFoundException, UsernameExistException, EmailExistException {
        User newUser = userService.register(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail());
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}
