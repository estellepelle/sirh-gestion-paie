package dev.paie.service;

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
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = { ServicesConfig.class })
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	@Autowired private CotisationService cotisService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder une nouvelle cotisation
		Integer id=  new Random().nextInt();
		Cotisation nouvelleCotis = new Cotisation();
		nouvelleCotis.setId(id);
	    nouvelleCotis.setCode("secu");
	    nouvelleCotis.setLibelle("Securite social");
	    nouvelleCotis.setTauxSalarial(new BigDecimal ("0.30"));
	    nouvelleCotis.setTauxPatronal(new BigDecimal ("0.30"));
	    
	    cotisService.sauvegarder(nouvelleCotis);
		
	// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via laméthode lister
	    List<Cotisation> listCotis =  cotisService.lister();
		
		assertTrue(listCotis.stream().anyMatch(g -> g.getId().equals(id)));
	    
	// TODO modifier une cotisation
		Cotisation cotisModifier = listCotis.get(0);

		cotisModifier.setCode("SECSOC");
		cotisService.mettreAJour(cotisModifier);
		
	// TODO vérifier que les modifications sont bien prises en compte via la éthode lister
		List<Cotisation> listeCotisApresModif = cotisService.lister();
		assertTrue(listeCotisApresModif.stream().filter(g -> g.getCode().equals("SECSOC")).count() > 0);
		
	}
	
}
