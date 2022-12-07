package com.techelevator.controller;

import com.techelevator.model.Ingredient;
import com.techelevator.model.Recipe;
import com.techelevator.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping(path = "/ingredients", method = RequestMethod.GET)
    public List<Ingredient> getAllIngredients(@RequestParam String name) {
        if (name.isBlank()) {
            return ingredientService.getAllIngredients();
        } else {
            return ingredientService.getIngredientByName(name);
        }
    }

    @RequestMapping(path = "/ingredients/{id}", method = RequestMethod.GET)
    public Ingredient getIngredientById(@PathVariable int id) {
        return ingredientService.getIngredientById(id);
    }

}