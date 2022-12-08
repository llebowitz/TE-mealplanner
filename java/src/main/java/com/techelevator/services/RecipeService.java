package com.techelevator.services;

import com.techelevator.dao.IngredientDao;
import com.techelevator.dao.RecipeDao;
import com.techelevator.dao.RecipeExistsException;
import com.techelevator.model.ExternalRecipeModel;
import com.techelevator.model.Ingredient;
import com.techelevator.model.Meal;
import com.techelevator.model.Recipe;
import com.techelevator.tasty.model.*;
import org.apache.commons.lang3.math.Fraction;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static net.gcardone.junidecode.Junidecode.unidecode;

@Component
public class RecipeService {

    private final RecipeDao recipeDao;
    private final IngredientDao ingredientDao;
    private RestTemplate restTemplate = new RestTemplate();
    private final static String API_URL = "https://www.themealdb.com/api/json/v1/1/random.php";
    private final static String TASTY_API_URL = "https://tasty.p.rapidapi.com/recipes/list?from=%d&size=%d";

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

    public void importTastyRecipes(int total){
        int start = 0;
        int interval;
        if(total < 40){
            interval = total;
        }else{
            interval = 40;
        }

        for(int i = start; i < total; i+= interval){
            TastyResults results = restTemplate.exchange(String.format(TASTY_API_URL, i, interval+i), HttpMethod.GET, getEntity(), TastyResults.class).getBody();

            for(TastyRecipe tr : results.getTastyRecipes()) {
                Recipe recipe = tastyToRecipe(tr);
                if (!recipeDao.doesRecipeExist(recipe.getName()) && !recipe.getInstructions().isBlank()) {
                    recipeDao.addRecipe(recipe);
                }
            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    private HttpEntity<Object>  getEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", "04d763f06bmsh4ad284ced759b32p111538jsn4756293adb85");
        headers.add("X-RapidAPI-Host", "tasty.p.rapidapi.com");
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        return requestEntity;
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

    private Recipe tastyToRecipe(TastyRecipe tr){
        Recipe recipe = new Recipe();
        recipe.setName(escape(tr.getName()));
        recipe.setBlurb(escape(tr.getDescription()));
        recipe.setImgLink(tr.getThumbnailUrl());
        recipe.setPublished(true);
        StringBuilder steps = new StringBuilder();
        if(tr.getInstructions() != null)
        {
            for(Instruction instruction : tr.getInstructions()){
                steps.append(escape(instruction.getDisplayText())).append("\n\n");
            }
        }
        recipe.setInstructions(escape(steps.toString()));
        List<Ingredient> ingredients = new ArrayList<>();
        if(tr.getSections() != null){
            for(Section s : tr.getSections()){
                for(TastyComponent tc : s.getComponents()){
                    Ingredient currentIngredient = new Ingredient();
                    currentIngredient.setName(escape(tc.getIngredient().getName()));
                    List<Measurement> measurements = tc.getMeasurements();
                    if(measurements.size() > 0){
                        currentIngredient.setMeasurement(escape(measurements.get(0).getUnit().getName()));
                        try{
                            currentIngredient.setQuantity(Fraction.getFraction(escape(measurements.get(0).getQuantity())).doubleValue());
                        }catch (Exception e){
                            System.out.println("Ingredient: " + currentIngredient.getName() + " Measurement: " + measurements.get(0).getQuantity() +" Recipe:" + recipe.getName());
                        }
                    }
                    ingredients.add(currentIngredient);
                }
            }
        }

        return recipe;
    }

    private String escape(String s){
        return s == null ? "" : unidecode(s).replace("'", "''");
    }

}
