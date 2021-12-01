package com.sdiezg.tacos.data;

import com.sdiezg.tacos.model.Ingredient;

public interface IngredientRepository {
	Ingredient save(Ingredient ingredient);
	Ingredient findOne(String id);
	Iterable<Ingredient> findAll();
}
