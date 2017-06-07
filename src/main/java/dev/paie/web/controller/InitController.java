package dev.paie.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDonneesService;

@Controller
public class InitController implements ApplicationListener<ContextRefreshedEvent>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InitController.class);

	@Autowired private InitialiserDonneesService initService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent ) {
		
		// Log de niveau INFO
		LOGGER.info("Initialisation des données");
		initService.initialiser();
	}

}
