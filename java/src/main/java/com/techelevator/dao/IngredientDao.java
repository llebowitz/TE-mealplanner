package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;

import java.util.List;

public interface IngredientDao {

    List<Ingredient> getIngredientsByRecipe(Recipe recipe);
    Ingredient getIngredientByName(String name);
    Ingredient getIngredientById(int id);
}
