package dev.paie.web.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.AvantageRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private ProfilRepository profilRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private RemunerationEmployeRepository employeRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		
		List<Entreprise> entreprise = entrepriseRepository.findAll();
		List<ProfilRemuneration> profil = profilRepository.findAll();
		List<Grade> grade = gradeRepository.findAll();
		
		mv.setViewName("employes/creerEmploye");
		mv.addObject("entreprise", entreprise);
		mv.addObject("profil",profil);
		mv.addObject("grade",grade);
		return mv;
	}
	

	@RequestMapping(method=RequestMethod.POST, value="/creer")
	@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
	 public String form(@RequestParam("matricule") String matricule, 
			 				  @RequestParam("grade") Integer gradeId, 
			 				  @RequestParam("profil") Integer profilId,
			 				  @RequestParam("entreprise") Integer entrepriseId,
			 				  Model model) {
       
		

		RemunerationEmploye renumEmploye = new RemunerationEmploye(matricule,entrepriseRepository.findOne(entrepriseId),profilRepository.findOne(profilId),gradeRepository.findOne(gradeId));
		renumEmploye.setDateCreation();
		employeRepository.saveAndFlush(renumEmploye);
	    
		
        
     return "redirect:/mvc/employes/creer";
    }
}
