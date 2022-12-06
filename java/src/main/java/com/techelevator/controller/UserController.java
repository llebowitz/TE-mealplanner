package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//TODO: Figure out role name for @PreAuthorize
public class UserController {

    public final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }
    //TODO: Figure out paths.
    //TODO: Add addUser, login, & deactivate methods. Done.

    @RequestMapping(path = "users/{id}/delete", method = RequestMethod.PUT)
    public boolean deactivate (@PathVariable int userId) {
        return userDao.deactivate(userId);
    }



}
