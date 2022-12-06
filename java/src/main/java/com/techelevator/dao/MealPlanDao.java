package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import com.techelevator.model.Recipe;

import java.util.List;

public interface MealPlanDao {

    MealPlan getMealPlan (int userId);
    List<Ingredient> createGroceryList(int planId);
    boolean addRecipeMealPlan (int recipeId, int userId);
    boolean deleteRecipeMealPlan (int recipeId, int userId);
}
