package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import com.techelevator.model.Recipe;
import com.techelevator.model.User;

import java.util.List;

public interface MealPlanDao {

    boolean addRecipeMealPlan (int recipeId, int userId);
    boolean deleteRecipeMealPlan (int recipeId, int userId);
    List<Ingredient> createGroceryList(int userId);
    MealPlan getMealPlan (User user);
}
