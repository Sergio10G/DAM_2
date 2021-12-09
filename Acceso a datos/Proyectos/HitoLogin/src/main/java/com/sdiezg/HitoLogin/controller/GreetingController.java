package com.sdiezg.HitoLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import com.sdiezg.HitoLogin.HitoLoginApplication;
import com.sdiezg.HitoLogin.data.UserRepository;
import com.sdiezg.HitoLogin.model.User;

@Slf4j
@Controller
@RequestMapping("/greeting")
public class GreetingController {
	@Autowired
	UserRepository userRepo;
	
	@GetMapping
	public String showGreetingView(Model model) {
		User loggedUser = HitoLoginApplication.loggedUser;
		if (loggedUser == null) {
			return "redirect:/home";
		}
		User user = userRepo.findOne(loggedUser.getEmail(), loggedUser.getPassword());
		if (user != null) {
			model.addAttribute("accepted", true);
			model.addAttribute("msg", "Usuario " + user.getEmail() + " loggeado con éxito.");
		}
		else {
			HitoLoginApplication.loggedUser = null;
			model.addAttribute("accepted", false);
			model.addAttribute("msg", "Alguno de los datos introducidos es incorrecto.");
		}
		return "greeting";
	}
	
	@GetMapping("/userexists")
	public String showUserExistsView(Model model) {
		model.addAttribute("accepted", false);
		model.addAttribute("msg", "El usuario ya existe.");
		return "greeting";
	}
	
}
