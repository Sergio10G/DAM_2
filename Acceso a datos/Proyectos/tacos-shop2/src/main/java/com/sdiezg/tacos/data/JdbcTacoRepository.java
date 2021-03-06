package com.sdiezg.tacos.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sdiezg.tacos.model.Ingredient;
import com.sdiezg.tacos.model.Taco;

@Repository
public class JdbcTacoRepository implements TacoRepository{
	
	private JdbcTemplate jdbc;

	public JdbcTacoRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Taco save(Taco design) {
		long tacoId = saveTacoInfo(design);
		design.setId(tacoId);
		for (Ingredient ingredient : design.getIngredients()) {
			saveIngredientToTaco(ingredient, tacoId);
		}
		return null;
	}

	private long saveTacoInfo(Taco design) {
		design.setCreatedAt(new Date());

		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory("INSERT INTO Taco(name, createdAt) VALUES (?, ?)", Types.VARCHAR, Types.TIMESTAMP);
		pscf.setReturnGeneratedKeys(true);
		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(Arrays.asList(design.getName(), new Timestamp(design.getCreatedAt().getTime())));
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(psc, keyHolder);
		Number id = keyHolder.getKey();
		return id.longValue();
	}
	
	private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
		jdbc.update("INSERT INTO Taco_Ingredient(taco_id, ingredient_id) VALUES (?, ?)", tacoId, ingredient.getId());
	}

	

	
}
