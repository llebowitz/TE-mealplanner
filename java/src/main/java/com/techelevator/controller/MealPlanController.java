package com.techelevator.controller;

import com.techelevator.model.Ingredient;
import com.techelevator.model.MealPlan;
import com.techelevator.model.MealPlanDto;
import com.techelevator.model.Recipe;
import com.techelevator.services.MealPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class MealPlanController {

    private final MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/users/mealplan", method = RequestMethod.GET)
    public MealPlan getMealPlan(Principal principal) {
        return mealPlanService.getMealPlanByUsername(principal.getName());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/users/mealplan", method = RequestMethod.POST)
    public void addRecipe(Principal principal, @RequestBody MealPlanDto mealPlanDto) {
        mealPlanService.addRecipeMealPlan(principal.getName(), mealPlanDto.getRecipeId());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/users/mealplan", method = RequestMethod.DELETE)
    public void deleteRecipe(Principal principal, @RequestBody MealPlanDto mealPlanDto) {
        mealPlanService.deleteRecipeMealPlan(principal.getName(), mealPlanDto.getRecipeId());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/users/mealplan/grocerylist", method = RequestMethod.GET)
    public List<Ingredient> createGroceryList(Principal principal) {
        return mealPlanService.createGroceryList(principal.getName());
    }

}
