package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.AvantageRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.ProfilRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private ProfilRepository profilRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		
		List<Entreprise> entreprise = entrepriseRepository.findAll();
		List<ProfilRemuneration> profil = profilRepository.findAll();
		
		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprise", entreprise);
		mv.addObject("profil",profil);
		return mv;
	}
	
}
