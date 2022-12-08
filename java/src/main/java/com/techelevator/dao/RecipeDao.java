package com.techelevator.dao;

import com.techelevator.model.Recipe;

import java.util.List;

public interface RecipeDao {

    boolean addRecipe (Recipe recipe);
    boolean deleteRecipe (Recipe recipe);
    boolean doesRecipeExist(String recipeName);
    boolean updateRecipe (Recipe recipe);
    List<Recipe> searchRecipes (String searchWord);
    List<Recipe> searchRecipesByIngredients (String ingredients);
    Recipe getRecipe(int recipeId);
    void removeRecipeFromUserList(int userId, int recipeId);
    void saveRecipeToUserList(int userId, int recipeId);

}
