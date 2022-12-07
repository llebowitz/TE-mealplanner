package com.techelevator.services;

import com.techelevator.dao.RecipeDao;
import com.techelevator.model.ExternalRecipeModel;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RecipeService {

    private final RecipeDao recipeDao;
    private RestTemplate restTemplate = new RestTemplate();
    private final static String API_URL = "https://www.themealdb.com/api/json/v1/1/random.php";

    public RecipeService(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public List<Recipe> searchRecipes(String searchWord) {
        return recipeDao.searchRecipes(searchWord);
    }

    public boolean importRecipe() {
        ExternalRecipeModel erm = restTemplate.getForObject(API_URL, ExternalRecipeModel.class);
        Recipe recipe = convertToRecipe(erm);
        return recipeDao.addRecipe(recipe);
    }

    private Recipe convertToRecipe(ExternalRecipeModel erm) {
        Recipe recipe = new Recipe();
        recipe.setName(erm.getStrMeal());
        recipe.setInstructions(erm.getStrInstructions());
        recipe.setImgLink(erm.getStrMealThumb());
        recipe.setIngredients(erm.getIngredientList());
        return recipe;
    }

}
