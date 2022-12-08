package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    List<Recipe> getUserRecipes (int userId);
    List<Recipe> searchRecipes (String searchWord);
    List<Recipe> searchRecipesByIngredients (String ingredients);
    Recipe getRecipe(int recipeId);
    boolean doesRecipeExist(String recipeName);
    boolean addRecipe (Recipe recipe);
    boolean updateRecipe (Recipe recipe);
    boolean deleteRecipe (Recipe recipe);
}
