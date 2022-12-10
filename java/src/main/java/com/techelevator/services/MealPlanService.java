package com.techelevator.services;

import com.techelevator.dao.MealPlanDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import com.techelevator.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MealPlanService {

    private final MealPlanDao mealPlanDao;
    private final UserDao userDao;

    public MealPlanService(MealPlanDao mealPlanDao, UserDao userDao) {
        this.mealPlanDao = mealPlanDao;
        this.userDao = userDao;
    }

    public MealPlan getMealPlan(User user) {
        return mealPlanDao.getMealPlan(user);
    }

    public List<Ingredient> createGroceryList(String username) {
        return mealPlanDao.createGroceryList(userDao.findByUsername(username).getId());
    }

    public boolean addRecipeMealPlan(String username, int dayOfWeek, int recipeId) {
        return mealPlanDao.addRecipeMealPlan(recipeId, dayOfWeek, userDao.findByUsername(username).getId());
    }

    public boolean deleteRecipeMealPlan(String username, int recipeId) {
        return mealPlanDao.deleteRecipeMealPlan(recipeId, userDao.findByUsername(username).getId());
    }

    public MealPlan getMealPlanByUsername(String username) {
        return mealPlanDao.getMealPlan(userDao.findByUsername(username));
    }
}
