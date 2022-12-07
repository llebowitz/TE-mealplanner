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

    public MealPlan getMealPlan (User user) {
        return mealPlanDao.getMealPlan(user);
    }

    public List<Ingredient> createGroceryList (int planId) {
        return mealPlanDao.createGroceryList(planId);
    }

    public boolean addRecipeMealPlan (int recipeId, int userId) {
        return mealPlanDao.addRecipeMealPlan(recipeId, userId);
    }

    public boolean deleteRecipeMealPlan (int recipeId, int userId) {
        return mealPlanDao.deleteRecipeMealPlan(recipeId, userId);
    }

    public MealPlan getMealPlanByUsername (String username) {
        return mealPlanDao.getMealPlan(userDao.findByUsername(username));
    }

}
