package com.project.foodrecipes.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.project.foodrecipes.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
	
	Optional<UnitOfMeasure> findByDescription(String description);	

}
