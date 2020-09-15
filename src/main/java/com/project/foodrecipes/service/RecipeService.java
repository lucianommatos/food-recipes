package com.project.foodrecipes.service;

import com.project.foodrecipes.model.Recipe;

public interface RecipeService {
	
	public Iterable<Recipe> findAllRecipes();

}
