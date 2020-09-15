package com.project.foodrecipes.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.foodrecipes.model.Category;
import com.project.foodrecipes.model.UnitOfMeasure;
import com.project.foodrecipes.repository.CategoryRepository;
import com.project.foodrecipes.repository.UnitOfMeasureRepository;

@Controller
public class IndexController {
	
	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage() {
		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Pinch");
		
		System.out.println("Category ID found: " + categoryOptional.get().getId());
		System.out.println("Category Desc found: " + categoryOptional.get().getDescription());
		
		System.out.println("UoM ID found: " + unitOfMeasureOptional.get().getId());
		System.out.println("UoM Desc found: " + unitOfMeasureOptional.get().getDescription());
		return "index";
	}

}
