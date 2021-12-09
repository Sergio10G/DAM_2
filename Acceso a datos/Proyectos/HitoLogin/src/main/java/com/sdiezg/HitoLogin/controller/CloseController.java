package com.sdiezg.HitoLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdiezg.HitoLogin.HitoLoginApplication;

@Controller
public class CloseController {
	
	@GetMapping("/close")
	public String showHomeView(Model model) {
		HitoLoginApplication.loggedUser = null;
		return "redirect:/home";
	}
}
