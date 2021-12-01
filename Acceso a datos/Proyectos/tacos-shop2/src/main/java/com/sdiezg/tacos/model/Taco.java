package com.sdiezg.tacos.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Taco {
	
	private long id;
	private Date createdAt;
	
	@NotNull
	@Size(min=5, message="El nombre debe tener al menos 5 caracteres.")
	private String name;
	private List<Ingredient> ingredients;
}
