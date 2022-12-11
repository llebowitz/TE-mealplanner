package com.techelevator.services;

import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.MealPlanDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MealPlanService {

    private final MealPlanDao mealPlanDao;
    private final UserDao userDao;
    private final IngredientDao ingredientDao;

    public MealPlanService(MealPlanDao mealPlanDao, UserDao userDao, IngredientDao ingredientDao) {
        this.mealPlanDao = mealPlanDao;
        this.userDao = userDao;
        this.ingredientDao = ingredientDao;
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

    public boolean deleteRecipeMealPlan(String username, int dayOfWeek, int recipeId) {
        return mealPlanDao.deleteRecipeMealPlan(recipeId, dayOfWeek, userDao.findByUsername(username).getId());
    }

    public MealPlan getMealPlanByUsername(String username) {
        MealPlan userMP = mealPlanDao.getMealPlan(userDao.findByUsername(username));

        List<Recipe> userRecipes = new ArrayList<>();
        for(Recipe r : userMP.getAllRecipes()){
            userRecipes.add(getIngredientsForMealPlan(r));
        }

        userMP.setRecipePerDay(userRecipes);

        return userMP;
    }

    private Recipe getIngredientsForMealPlan(Recipe r){
        r.setIngredients(ingredientDao.getIngredientsByRecipe(r));
        return r;
    }
}
