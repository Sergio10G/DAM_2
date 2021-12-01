package com.sdiezg.tacos.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class Order {
	@NotBlank(message="El nombre es obligatorio.")
	private String name;
	@NotBlank(message="La calle es obligatoria.")
	private String street;
	@NotBlank(message="El zip es obligatorio.")
	private String zip;
	@NotBlank(message="La ciudad es obligatoria.")
	private String city;
	@NotBlank(message="El estado es obligatorio.")
	private String state;
	@CreditCardNumber(message="La tarjeta es falsa.")
	private String ccNumber;
	@Pattern(regexp="^(0[1-9]|1[0-2])(\\/)([1-9][0-9])$", message="La fecha debe tener el formato: mm/yy")
	private String ccExpiration;
	@Digits(integer=3, fraction=0, message="CVV inválido.")
	private String ccCVV;
}
