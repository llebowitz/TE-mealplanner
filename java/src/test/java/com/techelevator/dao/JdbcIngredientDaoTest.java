package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.services.RecipeService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcIngredientDaoTest extends BaseDaoTests{

    @Test
    public void getIngredientsByRecipe_return_success() {
        IngredientDao ingredientDao = getIngredientDao();
        RecipeDao recipeDao = getRecipeDao();

        Recipe recipe = recipeDao.getRecipe(1);

        List<Ingredient> ingredients = ingredientDao.getIngredientsByRecipe(recipe);
        Assert.assertEquals(13, ingredients.size());
    }

//    @Test
//    public void getIngredientByName() {
//        IngredientDao ingredientDao = getIngredientDao();
//        RecipeDao recipeDao = getRecipeDao();
//
//        List<Ingredient> ingredient = ingredientDao.getIngredientByName("shallot");
//        Recipe recipe = recipeDao.getRecipe(1);
//
//        List<Ingredient> ingredients = ingredientDao.getIngredientsByRecipe(recipe);
//        Assert.assertEquals(13, ingredients.size());
//
//
//    }
//
//    @Test
//    public void getIngredientById() {
//    }
//
//    @Test
//    public void getAllIngredients() {
//    }

    private UserDao getUserDao() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        UserDao userDao = new JdbcUserDao(jdbcTemplate);
        return userDao;
    }

    private IngredientDao getIngredientDao() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        IngredientDao ingredientDao = new JdbcIngredientDao(jdbcTemplate);
        return ingredientDao;
    }

    private TagDao getTagDao() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        TagDao tagDao = new JdbcTagDao(jdbcTemplate);
        return tagDao;
    }

    private MealPlanDao getMealPlanDao() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        MealPlanDao mealPlanDao = new JdbcMealPlanDao(jdbcTemplate);
        return mealPlanDao;
    }

    private RecipeDao getRecipeDao() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        RecipeDao recipeDao = new JdbcRecipeDao(jdbcTemplate);
        return recipeDao;
    }

    private RecipeService getRecipeService() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        RecipeService recipeService = new RecipeService(getRecipeDao(), getIngredientDao(), getTagDao(), getUserDao());
        return recipeService;
    }
}