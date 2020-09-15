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


		Recipe grilledChickenTacos = new Recipe();

		grilledChickenTacos.getCategories().add(americanCategory.get());
		grilledChickenTacos.getCategories().add(mexicanCategory.get());

		Ingredient chiliPowder = new Ingredient("ancho chili powder", new BigDecimal("2"), grilledChickenTacos, tablespoonUom.get());
		Ingredient oregano = new Ingredient("dried oregano", new BigDecimal("1"), grilledChickenTacos, teaspoonUom.get());
		Ingredient cumin = new Ingredient("dried cumin", new BigDecimal("1"), grilledChickenTacos, teaspoonUom.get());
		Ingredient sugar = new Ingredient("sugar", new BigDecimal("1"), grilledChickenTacos, teaspoonUom.get());
		Ingredient salty = new Ingredient("salt", new BigDecimal("0.5"), grilledChickenTacos, teaspoonUom.get());
		Ingredient garlic = new Ingredient(" clove garlic, finely chopped", new BigDecimal("1"), grilledChickenTacos, eachUom.get());

		grilledChickenTacos.getIngredient().add(chiliPowder);
		grilledChickenTacos.getIngredient().add(oregano);
		grilledChickenTacos.getIngredient().add(cumin);
		grilledChickenTacos.getIngredient().add(sugar);
		grilledChickenTacos.getIngredient().add(salty);
		grilledChickenTacos.getIngredient().add(garlic);

		grilledChickenTacos.setDescription("Spicy Grilled Chicken Tacos");
		grilledChickenTacos.setPrepTime(20);
		grilledChickenTacos.setCookTime(15);
		grilledChickenTacos.setServings(6);
		grilledChickenTacos.setSource("Simply Recipes");
		grilledChickenTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
		grilledChickenTacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat."

				+ "\n" + "2 Make the marinade and coat the chicken: In a large bowl, stir together"
				+ "\n" + "the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in"				
				+ "\n" + "the orange juice and olive oil to make a loose paste. Add the chicken to the"				
				+ "\n" + "bowl and toss to coat all over."				
				+ "\n" + "Set aside to marinate while the grill heats and you prepare the rest of the toppings."

				+ "\n" + "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a"
				+ "\n" + "thermometer inserted into the thickest part of the meat registers 165F."
				+ "\n" + "Transfer to a plate and rest for 5 minutes."

				+ "\n" + "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet"
				+ "\n" + "over medium-high heat. As soon as you see pockets of the air start to puff"
				+ "\n" + "up in the tortilla, turn it with tongs and heat for a few seconds on the other side."
				+ "\n" + "Wrap warmed tortillas in a tea towel to keep them warm until serving."
				
				+ "\n" + "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a"
				+ "\n" + "small handful of arugula. Top with chicken slices, sliced avocado, radishes,"
				+ "\n" + "tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve"
				+ "\n" + "with lime wedges.");

		grilledChickenTacos.setDifficulty(Difficulty.MODERATE);

		grilledChickenTacos.setNotes(new Notes(grilledChickenTacos,
				"Look for ancho chile powder with the Mexican ingredients at your grocery store,"
				+ "\n" + "or buy it online. (If you can't find ancho chili powder, you replace the ancho chili,"
				+ "\n" + "the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though"
				+ "\n" + "the flavor won't be quite the same.)"));
		
		recipeRepository.save(grilledChickenTacos);
	}

}
