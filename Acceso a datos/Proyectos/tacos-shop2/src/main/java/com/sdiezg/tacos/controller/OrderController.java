package com.sdiezg.tacos.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdiezg.tacos.model.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		log.info("Mostrando el formulario de pago");
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder(Model model, @Valid Order order, Errors errors) {
		if (errors.hasErrors()) {
			model.addAttribute("order", order);
			log.info("Devuelto por malformado.");
			return "orderform";
		}
		log.info("Orden recibida: " + order);
		return "redirect:/";
	}
}
