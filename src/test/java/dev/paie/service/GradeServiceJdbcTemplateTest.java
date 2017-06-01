package dev.paie.service;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JeuxDeDonneesConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	
	@Autowired private GradeService gradeService;

	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	
	// TODO sauvegarder un nouveau grade
		Integer id=  new Random().nextInt();
		Grade nouveauGrade = new Grade();
		nouveauGrade.setId(id);
		nouveauGrade.setCode("sergent");
		nouveauGrade.setNbHeuresBase(new BigDecimal ("12.50"));
		nouveauGrade.setTauxBase(new BigDecimal ("5.0"));
		
		gradeService.sauvegarder(nouveauGrade);
		
		
	// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		List<Grade> listGrades =  gradeService.lister();
		
		assertTrue(listGrades.stream().anyMatch(g -> g.getId().equals(id)));
		
		
		
	// TODO modifier un grade
		Grade gradeModifier = listGrades.get(0);

		gradeModifier.setCode("capitaine");
		gradeService.mettreAJour(gradeModifier);
		
		
	// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		List<Grade> listeGradesApresModif = gradeService.lister();
		assertTrue(listeGradesApresModif.stream().filter(g -> g.getCode().equals("capitaine")).count() > 0);
	}
	
}
