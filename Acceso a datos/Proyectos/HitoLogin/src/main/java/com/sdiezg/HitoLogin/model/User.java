package com.sdiezg.HitoLogin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private int id;
	@NonNull
	private String email;
	@NonNull
	private String password;
}
