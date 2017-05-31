package dev.paie.service;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.*;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{
	
	@Autowired 
	private PaieUtils paieUtils;
	
	@Autowired 
	private ResultatCalculRemuneration res;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		BigDecimal salaireBase= bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
        res.setSalaireDeBase(paieUtils.formaterBigDecimal(salaireBase));
        
        BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
        res.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
        
        
        
        BigDecimal totalRetenueSalariale = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
        		.stream()
        		.filter(c -> c.getTauxSalarial() != null)
        		.map(c-> c.getTauxSalarial().multiply(salaireBrut))
        		.collect(Collectors.reducing((v1,v2) -> v1.add(v2))).get();
         res.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenueSalariale));

        
        BigDecimal totalCotisPatronale =  bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()
        		.stream()
        		.filter(c -> c.getTauxPatronal() != null)
        		.map(c-> c.getTauxPatronal().multiply(salaireBrut))
        		.collect(Collectors.reducing((v1,v2) -> v1.add(v2))).get();
        res.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisPatronale));
        
        BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalariale);
        res.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
        
        BigDecimal netAPayer = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()
        		.stream()
        		.filter(c -> c.getTauxSalarial() != null)
        		.map(c-> c.getTauxSalarial().multiply(salaireBrut))
        		.collect(Collectors.reducing((v1,v2) -> v1.add(v2))).get();
        res.setNetAPayer(paieUtils.formaterBigDecimal(netImposable.subtract(netAPayer)));
		
		return res;
	}

}
