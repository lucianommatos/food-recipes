package com.project.foodrecipes.service;

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
	public Iterable<Recipe> findAllRecipes() {
		return recipeRepository.findAll();
	}

}
