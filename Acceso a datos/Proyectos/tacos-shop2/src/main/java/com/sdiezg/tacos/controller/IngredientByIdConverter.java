package com.sdiezg.tacos.controller;

import org.springframework.core.convert.converter.Converter;

import com.sdiezg.tacos.data.IngredientRepository;
import com.sdiezg.tacos.model.Ingredient;

public class IngredientByIdConverter implements Converter<String, Ingredient>{

	private IngredientRepository ingredientRepository;
	
	public IngredientByIdConverter(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	@Override
	public Ingredient convert(String id) {
		return ingredientRepository.findOne(id);
	}
	
	
}
