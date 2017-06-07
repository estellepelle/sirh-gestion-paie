package dev.paie.config.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import dev.paie.entite.Performance;
import dev.paie.repository.PerformanceRepository;

@Configuration
@Aspect
public class ControllerPerformanceAspect {
	
	@Autowired PerformanceRepository perfRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPerformanceAspect.class);

	@Around("execution(* dev.paie.web.controller.*.*(..))")
	
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		
		Performance perf = new Performance();
		LocalDateTime now = LocalDateTime.now();
		String nomService = pjp.getSignature().toString();
		
		LOGGER.debug("Début d'exécution de la méthode " + nomService);
		Long before = System.currentTimeMillis();
		
	   
		Object resultat = pjp.proceed();
		LOGGER.debug("Fin d'exécution de la méthode");
		Long after = System.currentTimeMillis();
		
		perf.setDateHeure(now);
		perf.setTempsExecution(after - before);
		perf.setNomService(nomService);
		
		perfRepo.saveAndFlush(perf);
		return resultat;
		
	}
			
}
