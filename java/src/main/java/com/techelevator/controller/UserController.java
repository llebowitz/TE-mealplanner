package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import org.springframework.web.bind.annotation.RestController;

@RestController
//TODO: Figure out role name for @PreAuthorize
public class UserController {

    public final UserDao userDao;
    
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
    //TODO: Figure out paths.
    //TODO: Add addUser, login, & deactivate methods.
}
