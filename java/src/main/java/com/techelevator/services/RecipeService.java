package com.techelevator.services;

import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.RecipeExistsException;
import com.techelevator.model.ExternalRecipeModel;
import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RecipeService {

    private final RecipeDao recipeDao;
    private final IngredientDao ingredientDao;
    private RestTemplate restTemplate = new RestTemplate();
    private final static String API_URL = "https://www.themealdb.com/api/json/v1/1/random.php";

    public RecipeService(RecipeDao recipeDao, IngredientDao ingredientDao) {
        this.recipeDao = recipeDao;
        this.ingredientDao = ingredientDao;
    }

    public List<Recipe> searchRecipes(String searchWord) {
        List<Recipe> searchedRecipes = recipeDao.searchRecipes(searchWord);
        for(Recipe r : searchedRecipes){
            r.setIngredients(ingredientDao.getIngredientsByRecipe(r));
        }
        return searchedRecipes;
    }

    public boolean importRecipe(int count) {
        for(int i = 0; i < count; i++) {
            ExternalRecipeModel erm = restTemplate.getForObject(API_URL, ExternalRecipeModel.class);
            Meal meal = erm.getMeals().get(0);
            Recipe recipe = convertToRecipe(meal);
            if(!recipeDao.doesRecipeExist(recipe.getName())){
                recipeDao.addRecipe(recipe);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private Recipe convertToRecipe(Meal erm) {
        Recipe recipe = new Recipe();
        recipe.setName(erm.getStrMeal());
        recipe.setInstructions(erm.getStrInstructions());
        recipe.setImgLink(erm.getStrMealThumb());
        recipe.setIngredients(erm.getIngredientList());
        recipe.setPublished(true);
        return recipe;
    }

}
