package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MealPlanDto {
    @JsonProperty("recipeID")
    private int recipeID;
    @JsonProperty("dayOfWeek")
    private int dayOfWeek;

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
