package com.sdiezg.HitoLogin.data;

import com.sdiezg.HitoLogin.model.User;

public interface UserRepository {
	User save(User user);
	User findOne(String email, String password);
	Iterable<User> findAll();
}
