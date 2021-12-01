package com.sdiezg.tacos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdiezg.tacos.data.IngredientRepository;
import com.sdiezg.tacos.model.Ingredient;
import com.sdiezg.tacos.model.Ingredient.Type;
import com.sdiezg.tacos.model.Taco;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	
	@Autowired
	IngredientRepository ingredientRepo;
	
	@GetMapping
	public String showDesignForm(Model model) {
		fillModelIngredients(model);
		return "design";
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream()
			.filter(x -> x.getType().equals(type))
			.collect(Collectors.toList());
	}
	
	@PostMapping
	public String processDesign(@Valid @ModelAttribute(name="tktn") Taco design, Errors errors) {
		log.info("Procesando el diseño: " + design);
		if (errors.hasErrors()) {
			log.info("El usuario la cagó: " + errors.getAllErrors().toString());
			return "design";
		}
		return "redirect:/orders/current";
	}
	
	private void fillModelIngredients(Model model) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
	}
}
