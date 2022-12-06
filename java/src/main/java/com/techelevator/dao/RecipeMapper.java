package com.techelevator.dao;

import com.techelevator.model.Recipe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeMapper implements RowMapper<Recipe> {

    @Override
    public Recipe mapRow(ResultSet resultSet, int i) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setId(resultSet.getInt("recipe_id"));
        recipe.setName(resultSet.getString("recipe_name"));
        recipe.setCookTime(resultSet.getInt("cook_time"));
        recipe.setInstructions(resultSet.getString("instructions"));
        recipe.setPublished(resultSet.getBoolean("is_published"));
        recipe.setEdited(resultSet.getBoolean("is_edited"));
        if (resultSet.getString("blurb") != null) {
            recipe.setBlurb(resultSet.getString("blurb"));
        }
        return recipe;
    }
}
