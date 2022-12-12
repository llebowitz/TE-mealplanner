package com.techelevator.dao;

import com.techelevator.model.*;
import com.techelevator.services.RecipeService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcMealPlanDaoTest extends BaseDaoTests{

    @Test
    public void addRecipeMealPlan_return_success() {
        MealPlanDao mealPlanDao = getMealPlanDao();

        mealPlanDao.addRecipeMealPlan(1, 2,1);

        User user = new User();
        user.setId(1);
        MealPlan mealPlan = mealPlanDao.getMealPlan(user);
        mealPlan.setRecipePerDay(mealPlan.getAllRecipes());
        List<Recipe> recipes = mealPlan.getMonday();
        Assert.assertEquals(1, recipes.size());

        Recipe recipe = recipes.get(0);
        Assert.assertEquals(1, recipe.getId());
    }

    @Test
    public void createGroceryList_returns_list_of_ingredients_from_multiple_added_recipes() {
        MealPlanDao mealPlanDao = getMealPlanDao();
        mealPlanDao.addRecipeMealPlan(1,2, 1);
        mealPlanDao.addRecipeMealPlan(2,2, 1);
        mealPlanDao.createGroceryList(1);

        User user = new User();
        user.setId(1);
        MealPlan mealPlan = mealPlanDao.getMealPlan(user);
        List<Ingredient> ingredients = mealPlanDao.createGroceryList(1);
        Assert.assertEquals(13, ingredients.size());
    }

    @Test
    public void getMealPlan_returns_all_recipes() {
        MealPlanDao mealPlanDao = getMealPlanDao();

        mealPlanDao.addRecipeMealPlan(1, 2,1);
        mealPlanDao.addRecipeMealPlan(2, 3,1);

        User user = new User();
        user.setId(1);
        MealPlan mealPlan = mealPlanDao.getMealPlan(user);
        mealPlan.setRecipePerDay(mealPlan.getAllRecipes());
        List<Recipe> recipes = mealPlan.getAllRecipes();

        Recipe recipe = recipes.get(0);
        Assert.assertEquals(1, recipe.getId());
        recipes.get(1);
        Assert.assertEquals(1, recipe.getId());
    }

//    @Test
//    public void deleteRecipeMealPlan() {
//        MealPlanDao mealPlanDao = getMealPlanDao();
//
//        mealPlanDao.addRecipeMealPlan(1,2,1);
//        mealPlanDao.addRecipeMealPlan(1,2,1);
//        mealPlanDao.deleteRecipeMealPlan(1,2,1);
//        mealPlanDao.deleteRecipeMealPlan(2,2,1);
//
//        User user = new User();
//        user.setId(1);
//        MealPlan mealPlan = mealPlanDao.getMealPlan(user);
//        mealPlan.setRecipePerDay(mealPlan.getAllRecipes());
//        List<Recipe> recipes = mealPlan.getAllRecipes();
//
//        Recipe recipe = recipes.get(0);
//        Assert.assertEquals(null, recipe.getId());
//        recipes.get(1);
//        Assert.assertEquals(null, recipe.getId());
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