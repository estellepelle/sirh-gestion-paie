package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDonneesService;

@Controller
public class InitController implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired private InitialiserDonneesService initService;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent ) {
		initService.initialiser();
	}

}
