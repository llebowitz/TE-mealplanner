package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private int id;
    private int cookTime;
    private String blurb;
    private String instructions;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();
    private final List<Tag> tags = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public String getName() {
        return name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Tag> getTags(){
        return tags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public void setIngredients(List<Ingredient> ingredients){
        this.ingredients.addAll(ingredients);
    }

    public void setComments(List<Comment> comments){
        this.comments.addAll(comments);
    }

    public void setTags(List<Tag> tags){
        this.tags.addAll(tags);
    }

    public void addIngredient(Ingredient i){
        this.ingredients.add(i);
    }

    public void addComment(Comment c){
        this.comments.add(c);
    }

    public void addTag(Tag t){
        this.tags.add(t);
    }
}
