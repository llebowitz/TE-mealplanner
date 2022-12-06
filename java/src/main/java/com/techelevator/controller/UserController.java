package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//TODO: Figure out role name for @PreAuthorize
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //TODO: deactivate method. Done.

    @RequestMapping(path = "users/{id}/delete", method = RequestMethod.PUT)
    public boolean deactivate (@PathVariable int userId) {
        return userService.deactivate(userId);
    }
}
