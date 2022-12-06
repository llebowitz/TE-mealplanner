package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcRecipeDao implements RecipeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecipeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Recipe> getUserRecipes(int userId) {
        String sql = "SELECT * FROM recipes r JOIN users_recipes ur ON r.recipe_id = ur.recipe_id WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        List<Recipe> myRecipes = new ArrayList<>();
        while (results.next()) {
            myRecipes.add(mapRowToRecipe(results));
        }
        return myRecipes;
    }

    @Override
    public List<Recipe> searchRecipesByName(String name) {
        String sql = "SELECT * FROM recipes WHERE recipe_name ILIKE ?";
        name = "%" + name + "%";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        List<Recipe> myRecipes = new ArrayList<>();
        while (results.next()) {
            myRecipes.add(mapRowToRecipe(results));
        }
        return myRecipes;
    }

    @Override
    public List<Recipe> searchRecipesByIngredients(String ingredients) {
        String sql = "SELECT DISTINCT r.recipe_id, recipe_name, cook_time, blurb, instructions FROM recipes r JOIN recipes_ingredients ri ON r.recipe_id = ri.recipe_id JOIN ingredients i ON i.ingredient_id = ri.ingredient_id" +
                "WHERE ingredient_name ILIKE ?";
        ingredients = "%" + ingredients + "%";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ingredients);
        List<Recipe> searchedIngredients = new ArrayList<>();
        while (results.next()) {
            searchedIngredients.add(mapRowToRecipe(results));
        }
        return searchedIngredients;
    }

    @Override
    public Recipe getRecipe(int recipeId) {
        String sql = "SELECT * FROM recipes WHERE recipe_id = ?";
        Recipe results = jdbcTemplate.queryForObject(sql, Recipe.class, recipeId);
        return results;
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        return false;
    }

    @Override
    public boolean updateRecipe(Recipe recipe) {
        return false;
    }

    @Override
    public boolean deleteRecipe(Recipe recipe) {
        return false;
    }

    private Recipe mapRowToRecipe(SqlRowSet row) {
        Recipe recipe = new Recipe();
        recipe.setId(row.getInt("recipe_id"));
        recipe.setName(row.getString("recipe_name"));
        recipe.setCookTime(row.getInt("cook_time"));
        recipe.setInstructions(row.getString("instructions"));
        recipe.setPublished(row.getBoolean("is_published"));
        recipe.setEdited(row.getBoolean("is_edited"));
        if (row.getString("blurb") != null) {
                recipe.setBlurb(row.getString("blurb"));
        }
        return recipe;
    }

}
