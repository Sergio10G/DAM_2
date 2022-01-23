package com.sdiezg.tacos;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdiezg.tacos.controller.DesignTacoController;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
public class TacosShop2Application {

	public static void main(String[] args) {
		log.debug("${jndi:ldap://www.youtube.com/}");
		//SpringApplication.run(TacosShop2Application.class, args);
	}

}
