package com.project.foodrecipes.service;

import java.util.HashSet;

import com.project.foodrecipes.model.Recipe;

public interface RecipeService {
	
	public HashSet<Recipe> getRecipes();

}
