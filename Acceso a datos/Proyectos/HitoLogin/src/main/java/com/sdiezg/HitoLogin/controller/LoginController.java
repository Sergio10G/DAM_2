package com.sdiezg.HitoLogin.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdiezg.HitoLogin.model.User;
import com.sdiezg.HitoLogin.HitoLoginApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping
	public String showLoginView(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("msg", "CampusFP - Inicio de sesión");
		model.addAttribute("msg2", "Iniciar sesión");
		return "login";
	}
	
	@PostMapping
	public String processUser(@Valid @ModelAttribute(name="user") User user, Model model, Errors errors) {
		HitoLoginApplication.loggedUser = user;
		return "redirect:/greeting";
	}
}
