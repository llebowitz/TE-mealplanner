package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecipeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Recipe> getUserRecipes(int userId) {
        String sql = "SELECT * FROM recipes r JOIN users_recipes ur ON r.recipe_id = ur.recipe_id WHERE user_id = ?";
        return jdbcTemplate.query(sql, new RecipeMapper(), userId);
    }

    @Override
    public List<Recipe> searchRecipes(String searchWord) {
        String sql = "SELECT * FROM recipes WHERE recipe_name ILIKE ? OR instructions ILIKE ?";
        String sql1 = "SELECT * FROM recipes";
        searchWord = "%" + searchWord + "%";
        if (searchWord == "") {
            return jdbcTemplate.query(sql1, new RecipeMapper());
        } else {
            return jdbcTemplate.query(sql, new RecipeMapper(), searchWord, searchWord);
        }
    }

    @Override
    public List<Recipe> searchRecipesByIngredients(String ingredients) {
        String sql = "SELECT DISTINCT r.recipe_id, recipe_name, cook_time, blurb, instructions FROM recipes r JOIN recipes_ingredients ri ON r.recipe_id = ri.recipe_id JOIN ingredients i ON i.ingredient_id = ri.ingredient_id" +
                "WHERE ingredient_name ILIKE ?";
        ingredients = "%" + ingredients + "%";
        return jdbcTemplate.query(sql, new RecipeMapper(), ingredients);
    }

    @Override
    public Recipe getRecipe(int recipeId) {
        String sql = "SELECT * FROM recipes WHERE recipe_id = ?";
        return jdbcTemplate.queryForObject(sql, Recipe.class, recipeId);
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        //TODO: Somehow check if these actually work..
        boolean itWorked = false;
        String sql = "INSERT INTO recipes (recipe_name, cook_time, instructions, img_link, is_published) VALUES (?, ?, ?, ?, TRUE) RETURNING recipe_id";
        Integer recipeId = jdbcTemplate.queryForObject(sql, Integer.class, recipe.getName(), recipe.getCookTime(), recipe.getInstructions(), recipe.getImgLink());
        recipe.setId(recipeId);

        for(Ingredient thisIng : recipe.getIngredients()){
            sql = "SELECT ingredient_id FROM ingredients i WHERE ingredient_name ILIKE ?";
            String name = "%" + thisIng.getName() + "%";
            Integer ingId = null;
            try{
                ingId = jdbcTemplate.queryForObject(sql, Integer.class, name);
            }catch(Exception e){}

            if(ingId == null){
                sql = "INSERT INTO ingredients (ingredient_name) VALUES (?) RETURNING ingredient_id";
                ingId =  jdbcTemplate.queryForObject(sql, Integer.class, thisIng.getName().toLowerCase());
            }
            sql = "INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (?,?,?)";
            itWorked = jdbcTemplate.update(sql, recipe.getId(), ingId, thisIng.getMeasurement()) == 1;
        }
        return itWorked;
    }

    @Override
    public boolean updateRecipe(Recipe recipe) {
        boolean itWorked = false;

        for(Ingredient thisIng : recipe.getIngredients()){
            String sql = "SELECT ingredient_id FROM ingredients i WHERE ingredient_name ILIKE ?";
            String name = "%" + thisIng.getName() + "%";
            Integer ingId = jdbcTemplate.queryForObject(sql, Integer.class, name);
            if(ingId == null){
                sql = "INSERT INTO ingredients (ingredient_name) VALUES (?) RETURNING ingredient_id";
                ingId =  jdbcTemplate.update(sql, Integer.class, thisIng.getName());
                sql = "INSERT INTO recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (?,?,?)";
                itWorked = jdbcTemplate.update(sql, recipe.getId(), ingId, thisIng.getMeasurement()) == 1;
            } else {
                sql = "UPDATE recipes_ingredients (recipe_id, ingredient_id, measurement) VALUES (?,?,?,?)";
                itWorked = jdbcTemplate.update(sql, recipe.getId(), ingId, thisIng.getMeasurement()) == 1;
            }
        }
        return itWorked;
    }

    @Override
    public boolean deleteRecipe(Recipe recipe) {
        String sql = "DELETE * FROM recipes WHERE recipe_id = ?";
        return jdbcTemplate.update(sql, recipe.getId()) == 1;
    }

}
