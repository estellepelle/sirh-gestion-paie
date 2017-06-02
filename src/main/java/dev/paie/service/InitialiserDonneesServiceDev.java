package dev.paie.service;



import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;


@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	
	@Autowired private ApplicationContext context;

	@PersistenceContext EntityManager em;
	

	
	
	@Transactional
	@Override
	public void initialiser() {
		
		context.getBeansOfType(Grade.class).forEach((nomBean, bean) -> em.persist(bean));
		context.getBeansOfType(Cotisation.class).forEach((nomBean, bean) -> em.persist(bean));
		context.getBeansOfType(Entreprise.class).forEach((nomBean, bean) -> em.persist(bean));
		context.getBeansOfType(ProfilRemuneration.class).forEach((nomBean, bean) -> em.persist(bean));
		

		
		int curDate = LocalDate.now().getYear();


		for(int i=1;i<13; i++){
			LocalDate localDate = LocalDate.of(curDate,i,1);
			em.persist(new Periode(localDate, localDate.with(TemporalAdjusters.lastDayOfMonth())));
		}
		
		
		
		
		
		
		
	}

}
