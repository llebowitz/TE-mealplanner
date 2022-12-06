package com.techelevator.controller;


import com.techelevator.model.Recipe;
import com.techelevator.services.RecipeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO: Figure out paths.
@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(path = "/recipes", method = RequestMethod.GET)
    public List<Recipe> recipeSearch(@RequestParam String searchWord) {
        return recipeService.searchRecipes(searchWord);
    }


}