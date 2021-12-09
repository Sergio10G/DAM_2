package com.sdiezg.HitoLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdiezg.HitoLogin.HitoLoginApplication;
import com.sdiezg.HitoLogin.data.UserRepository;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepo;
	
	@GetMapping({"/", "/home"})
	public String showHomeView(Model model) {
		model.addAttribute("loggedUser", HitoLoginApplication.loggedUser);
		model.addAttribute("userList", userRepo.findAll());
		return "home";
	}
}
