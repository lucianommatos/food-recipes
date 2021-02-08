package com.project.foodrecipes.service;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.project.foodrecipes.model.Recipe;
import com.project.foodrecipes.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public HashSet<Recipe> getRecipes() {
		HashSet<Recipe> recipes = new HashSet<Recipe>();
		recipeRepository.findAll().forEach(recipes::add);
		return recipes;
	}

}
