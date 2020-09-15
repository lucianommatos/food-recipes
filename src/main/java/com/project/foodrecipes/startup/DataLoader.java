package com.project.foodrecipes.startup;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.project.foodrecipes.enums.Difficulty;
import com.project.foodrecipes.model.Category;
import com.project.foodrecipes.model.Ingredient;
import com.project.foodrecipes.model.Notes;
import com.project.foodrecipes.model.Recipe;
import com.project.foodrecipes.model.UnitOfMeasure;
import com.project.foodrecipes.repository.CategoryRepository;
import com.project.foodrecipes.repository.RecipeRepository;
import com.project.foodrecipes.repository.UnitOfMeasureRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private RecipeRepository recipeRepository;
	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;	

	public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadData();
	}
	
	public void loadData() {
		
		Optional<UnitOfMeasure> teaspoonUom = unitOfMeasureRepository.findByDescription("Teaspoon");		
		Optional<UnitOfMeasure> tablespoonUom = unitOfMeasureRepository.findByDescription("Tablespoon");		
		Optional<UnitOfMeasure> cupUom = unitOfMeasureRepository.findByDescription("Cup");		
		Optional<UnitOfMeasure> pinchUom = unitOfMeasureRepository.findByDescription("Pinch");		
		Optional<UnitOfMeasure> ounceUom = unitOfMeasureRepository.findByDescription("Ounce");		
		Optional<UnitOfMeasure> eachUom = unitOfMeasureRepository.findByDescription("Each");		
		Optional<UnitOfMeasure> dashUom = unitOfMeasureRepository.findByDescription("Dash");		
		Optional<UnitOfMeasure> pintUom = unitOfMeasureRepository.findByDescription("Pint");
		
		Optional<Category> americanCategory = categoryRepository.findByDescription("American");
		Optional<Category> italianCategory = categoryRepository.findByDescription("Italian");
		Optional<Category> mexicanCategory = categoryRepository.findByDescription("Mexican");
		Optional<Category> fastFoodCategory = categoryRepository.findByDescription("Fast Food");
		
		Recipe guacamoleRecipe = new Recipe();
		
		guacamoleRecipe.getCategories().add(mexicanCategory.get());
		
		Ingredient avocado = new Ingredient("ripe avocados", new BigDecimal("2"), guacamoleRecipe, eachUom.get());
		Ingredient salt = new Ingredient("salt", new BigDecimal("0.25"), guacamoleRecipe, teaspoonUom.get());
		Ingredient lemonJuice = new Ingredient("fresh lime juice or lemon juice", new BigDecimal("1"), guacamoleRecipe, tablespoonUom.get());
		Ingredient onion = new Ingredient("ablespoons to 1/4 cup of minced red onion or thinly sliced green onion", new BigDecimal("2"), guacamoleRecipe, tablespoonUom.get());
		Ingredient chiles = new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal("1"), guacamoleRecipe, eachUom.get());
		
		guacamoleRecipe.getIngredient().add(avocado);
		guacamoleRecipe.getIngredient().add(salt);
		guacamoleRecipe.getIngredient().add(lemonJuice);
		guacamoleRecipe.getIngredient().add(onion);
		guacamoleRecipe.getIngredient().add(chiles);
		
		guacamoleRecipe.setDescription("Perfect Guacamole");
		guacamoleRecipe.setPrepTime(10);
		guacamoleRecipe.setCookTime(0);
		guacamoleRecipe.setServings(4);
		guacamoleRecipe.setSource("Simply Recipes");
		guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		guacamoleRecipe.setDirections("1 - Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. "
				+ "\n" + "Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon."
				+ "\n" + "2 - Mash with a fork: Using a fork, roughly mash the avocado. "
				+ "\n" + "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon"
				+ "\n" + "juice. The acid in the lime juice will provide some balance to the richness of"
				+ "\n" + "the avocado and will help delay the avocados from turning brown."
				+ "\n" + "4 Serve: Serve immediately, or if making a few hours ahead, place plastic"
				+ "\n" + "wrap on the surface of the guacamole and press down to cover it and to"
				+ "\n" + "prevent air reaching it. (The oxygen in the air causes oxidation which will"
				+ "\n" + "turn the guacamole brown.) Refrigerate until ready to serve.");
		
		guacamoleRecipe.setDifficulty(Difficulty.EASY);
		
		guacamoleRecipe.setNotes(new Notes(guacamoleRecipe,"Be careful handling chiles if using. Wash your hands thoroughly after handling and "
				+ "\n" + "do not touch your eyes or the area near your eyes with your hands for several hours."));
		
		recipeRepository.save(guacamoleRecipe);
	}

}
