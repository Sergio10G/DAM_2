package com.sdiezg.HitoLogin.data;

import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.sdiezg.HitoLogin.model.User;

@Repository
public class JdbcUserRepository implements UserRepository{
	
	private JdbcTemplate jdbc;

	public JdbcUserRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public User save(User user) {
		int userId = saveUserInfo(user);
		user.setId(userId);
		return user;
	}
	
	private int saveUserInfo(User user) {
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory("INSERT INTO user(email, password) VALUES (?, ?)", Types.VARCHAR, Types.VARCHAR);
		pscf.setReturnGeneratedKeys(true);
		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(Arrays.asList(user.getEmail(), user.getPassword()));
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(psc, keyHolder);
		Number id = keyHolder.getKey();
		return id.intValue();
	}

	@Override
	public User findOne(String email, String password) {
		User user = null;
		try {
			user = jdbc.queryForObject("SELECT * FROM user WHERE email = ? AND password = ?", this::mapRowToUser, email, password);
		} catch (Exception e) {
			
		}
		return user;
	}

	@Override
	public Iterable<User> findAll() {
		return jdbc.query("SELECT * FROM user", this::mapRowToUser);
	}
	
	private User mapRowToUser(ResultSet rs, int rowNum) {
		User user = null;
		try {
			user = new User(rs.getInt("id"), 
					rs.getString("email"),
					rs.getString("password"));
		}
		catch(Exception e) {
			//e.printStackTrace();
		}
		return user;
	}

}
