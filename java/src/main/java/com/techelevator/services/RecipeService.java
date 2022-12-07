package com.techelevator.services;

import com.techelevator.dao.RecipeDao;
import com.techelevator.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeService {

    private final RecipeDao recipeDao;

    public RecipeService(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public List<Recipe> searchRecipes(String searchWord) {
        return recipeDao.searchRecipes(searchWord);
    }

    public boolean importRecipe() { }

}
