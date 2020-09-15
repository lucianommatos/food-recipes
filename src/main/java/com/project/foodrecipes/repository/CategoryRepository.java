package com.project.foodrecipes.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.foodrecipes.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
