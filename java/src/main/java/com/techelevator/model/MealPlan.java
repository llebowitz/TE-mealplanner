package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {
    private User user;
    private final List<Recipe> recipes = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes){
        this.recipes.addAll(recipes);
    }

    public void addRecipe(Recipe r){
        this.recipes.add(r);
    }
}
