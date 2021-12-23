package com.hp.web.portal.gram_sadak.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

	@Around("execution(* com.sk..*.*(..))")
	public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		LOGGER.debug("***** Starting: {}  *****",
				proceedingJoinPoint.getSignature().getName());
		Object output = proceedingJoinPoint.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		LOGGER.debug("***** Completed: {} in {} (ms) *****",
				proceedingJoinPoint.getSignature().getName(), elapsedTime);
		return output;
	}

}
