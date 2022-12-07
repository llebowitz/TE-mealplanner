package com.techelevator.services;

import com.techelevator.dao.MealPlanDao;
import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MealPlanService {

    private final MealPlanDao mealPlanDao;

    public MealPlanService(MealPlanDao mealPlanDao) {
        this.mealPlanDao = mealPlanDao;
    }

    public MealPlan getMealPlan (int userId) {
        return mealPlanDao.getMealPlan(userId);
    }

    public List<Ingredient> createGroceryList (int planId) {
        return mealPlanDao.createGroceryList(planId);
    }

    public boolean addRecipeMealPlan (int recipe) {
        return true;
    }

}
