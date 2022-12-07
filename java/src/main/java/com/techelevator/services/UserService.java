package com.techelevator.services;

import com.techelevator.dao.MealPlanDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserDao userDao;
    private final RecipeDao recipeDao;
    private final MealPlanDao mealPlanDao;

    public UserService(UserDao userDao, RecipeDao recipeDao, MealPlanDao mealPlanDao) {
        this.userDao = userDao;
        this.recipeDao = recipeDao;
        this.mealPlanDao = mealPlanDao;
    }

    public User findByUsername(String username) {
        User u = userDao.findByUsername(username);
        u.setMyRecipes(recipeDao.getUserRecipes(u.getId()));
        u.setMyMealPlan(mealPlanDao.getMealPlan(u));
        return u;
    }

    public boolean create(String username, String password, String role) {
        return userDao.create(username, password, role);
    }

    public boolean deactivate (int userId) {
        return userDao.deactivate(userId);
    }

}
