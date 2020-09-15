package com.project.foodrecipes.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.foodrecipes.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
