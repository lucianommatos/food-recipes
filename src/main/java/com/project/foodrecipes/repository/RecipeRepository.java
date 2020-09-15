package com.project.foodrecipes.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.foodrecipes.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
