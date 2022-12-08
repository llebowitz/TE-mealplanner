package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.Recipe;
import com.techelevator.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
//COMPLETED: Figure out role name for @PreAuthorize
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "users/{id}/delete", method = RequestMethod.PUT)
    public boolean deactivate(@PathVariable int userId) {
        return userService.deactivate(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/users/recipes", method = RequestMethod.POST)
    public void saveRecipeToUserList(int recipeId, Principal principal) {
        userService.saveRecipeToUserList(recipeId, principal.getName());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/users/recipes", method = RequestMethod.DELETE)
    public void removeRecipeFromUserList(int recipeId, Principal principal) {
        userService.removeRecipeFromUserList(recipeId, principal.getName());
    }

    public List<Recipe> getUsersRecipes(Principal principal) {
        return userService.getUserRecipes(principal.getName());
    }

}

//COMPLETED: deactivate method. Done.