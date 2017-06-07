package dev.paie.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class ControllerPerformanceAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPerformanceAspect.class);

	@Around("execution(* dev.paie.web.controller.*.*(..))")
	
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		
		LOGGER.debug("Début d'exécution de la méthode " + pjp.getSignature().toString());
		
	    
		
		Object resultat = pjp.proceed();
		LOGGER.debug("Fin d'exécution de la méthode");
		
		return resultat;
		
	}
			
}
