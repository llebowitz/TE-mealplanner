package com.techelevator.controller;

import com.techelevator.model.MealPlan;
import com.techelevator.model.User;
import com.techelevator.services.MealPlanService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
public class MealPlanController {

    private final MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @RequestMapping(path = "/mealplan", method = RequestMethod.GET)
    public MealPlan getMealPlan(Principal principal) {
        return mealPlanService.getMealPlanByUsername(principal.getName());
    }


}
