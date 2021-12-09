package com.sdiezg.HitoLogin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdiezg.HitoLogin.model.User;
import com.sdiezg.HitoLogin.HitoLoginApplication;
import com.sdiezg.HitoLogin.data.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	UserRepository userRepo;
	
	@GetMapping
	public String showLoginView(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("msg", "CampusFP - Registro de usuario");
		model.addAttribute("msg2", "Registrarse");
		return "login";
	}
	
	@PostMapping
	public String processUser(@Valid @ModelAttribute(name="user") User user, Model model, Errors errors) {
		User foundUser = userRepo.findOne(user.getEmail(), user.getPassword());
		if (foundUser != null) {
			HitoLoginApplication.loggedUser = null;
			return "redirect:/greeting/userexists";
		}
		HitoLoginApplication.loggedUser = userRepo.save(user);
		return "redirect:/greeting";
	}
}
