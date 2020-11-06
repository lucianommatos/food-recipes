package com.project.foodrecipes.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryTest {
	
	Category category;
	
	@BeforeEach
	public void setUp() {
		category = new Category();
	}
	
	@Test
	public void getId() {
		Long idValue = 3L;
		category.setId(idValue);
		Assertions.assertEquals(idValue, category.getId());
	}
	
	@Test
	public void getDescription() {
		String description = "Brazilian Food";
		category.setDescription(description);
		Assertions.assertEquals(description, category.getDescription());
	}
	
	@Test
	public void getRecipes() {
		
	}

}
