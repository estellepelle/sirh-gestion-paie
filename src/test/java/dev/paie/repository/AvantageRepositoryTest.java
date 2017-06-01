package dev.paie.repository;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		
	// TODO sauvegarder un nouvel avantage
		Integer id=  new Random().nextInt();
		Avantage nouvelleAvt = new Avantage();
		nouvelleAvt.setId(id);
		nouvelleAvt.setCode("REP");
		nouvelleAvt.setNom("ticket restaurant");
		nouvelleAvt.setMontant(new BigDecimal ("10.00"));
		
	   avantageRepository.save(nouvelleAvt);
		
	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
	   List<Avantage> listAvt =  avantageRepository.findAll();
		
	   assertTrue(listAvt.stream().anyMatch(g -> g.getId().equals(id)));
	   
	// TODO modifier un avantage
	   Avantage avtModifier = listAvt.get(0);

	   avtModifier.setCode("Ticket");
	   avantageRepository.save(avtModifier);
	   
	// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
	   List<Avantage> listeAvtApresModif = avantageRepository.findAll();
	   assertTrue(listeAvtApresModif.stream().filter(g -> g.getCode().equals("Ticket")).count() > 0);
	 
	   //chercher par code
	   avantageRepository.findByCode("Ticket");
	}

}
