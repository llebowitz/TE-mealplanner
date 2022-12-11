package com.techelevator.dao;

import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcMealPlanDao implements MealPlanDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMealPlanDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public MealPlan getMealPlan(User user) {
        String sql = "SELECT * FROM recipes r JOIN recipes_meal_plan rmp ON r.recipe_id = rmp.recipe_id " +
                "JOIN meal_plan mp ON rmp.plan_id = mp.plan_id WHERE user_id = ?";
        MealPlan mealplan = new MealPlan();
        mealplan.setRecipes(jdbcTemplate.query(sql, new RecipeMapper(), user.getId()));
        return mealplan;
    }

    @Override
    public boolean createMealPlan(int userId){
        String sql = "INSERT INTO meal_plan (user_id) VALUES (?) RETURNING plan_id";
        return jdbcTemplate.queryForObject(sql, Integer.class, userId) > 0;
    }

    @Override
    public List<Ingredient> createGroceryList(int userId) {
        String sql = "SELECT DISTINCT i.ingredient_name, i.ingredient_id, ri.measurement, ri.quantity FROM ingredients i " +
                "JOIN recipes_ingredients ri ON ri.ingredient_id = i.ingredient_id " +
                "JOIN recipes_meal_plan rmp ON rmp.recipe_id = ri.recipe_id " +
                "JOIN meal_plan mp ON mp.plan_id = rmp.plan_id WHERE mp.user_id = ?";
        return jdbcTemplate.query(sql, new IngredientMapper(), userId);
    }

    @Override
    public boolean addRecipeMealPlan(int recipeId, int dayOfWeek, int userId) {
        String sql = "INSERT into recipes_meal_plan (recipe_id, day_of_week, plan_id) VALUES (?, ?, (SELECT plan_id FROM meal_plan WHERE user_id = ?))";
        return jdbcTemplate.update(sql, recipeId, dayOfWeek, userId) == 1;
    }

    //TO DO: look into day_of_week type as string in database
    @Override
    public boolean deleteRecipeMealPlan(int recipeId, Integer dayOfWeek, int userId) {
        String sql = "DELETE FROM recipes_meal_plan WHERE recipe_id = ? AND day_of_week = ? AND plan_id = (SELECT plan_id FROM meal_plan WHERE user_id = ?)";
        return jdbcTemplate.update(sql, recipeId, dayOfWeek.toString(), userId) == 1;
    }

}
