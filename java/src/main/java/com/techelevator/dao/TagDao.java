package com.techelevator.dao;

import com.techelevator.model.Recipe;
import com.techelevator.model.Tag;

public interface TagDao {
    void addTags(Recipe recipe);
    void removeTags(Recipe recipe);
}
