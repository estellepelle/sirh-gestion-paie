package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class ListerEmployeController {
	
	@Autowired
	private RemunerationEmployeRepository employeRepository;
	
	@RequestMapping(method = RequestMethod.GET, path="/lister")
	public ModelAndView listerEmploye() {
		ModelAndView mv = new ModelAndView();
		
		List< RemunerationEmploye> employe= employeRepository.findAll();
	
		mv.setViewName("employes/listerEmploye");
		mv.addObject("employe",employe);
		return mv;
	}
}
