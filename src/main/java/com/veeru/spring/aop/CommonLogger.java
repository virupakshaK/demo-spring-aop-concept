/**
 * 
 */
package com.veeru.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.veeru.spring.dto.EmployeeDTO;
import com.veeru.spring.exceptionhandlers.ObjectNotFoundException;


/**
 * @author Virupaksha K
 *
 */

@Aspect
@Component
public class CommonLogger {

	Logger logger = LoggerFactory.getLogger(CommonLogger.class);

	// @Pointcut("within(com.veeru.spring.controllers..*)")
	// @Pointcut("this(com.veeru.spring.controllers.EmployeeController)")
	// @Pointcut("@annotation(com.veeru.spring.customAnnotation.CustomAnnotation)")
	@Pointcut("execution(* com.veeru.spring.controllers.*.getMessage(..))")
	public void printRequestPointCut() {
	}

	@Before("printRequestPointCut()")
	public void beforeMethodCall() {

		logger.info("Before Request process to method");
	}

	@After("printRequestPointCut()")
	public void afterMethodCall() {
		logger.info("After returning from method response");
	}

	@Pointcut("execution(* com.veeru.spring.controllers.EmployeeController.saveEmployee(..))")
	public void anotherPointcut() {

	}

	@Around("anotherPointcut()")
	public Object aroundAdviceUsage(ProceedingJoinPoint proceedingJoinPoint) {
		logger.info("Before request process: {}", proceedingJoinPoint.getArgs()[0]);

		Object obj = null;
		try {
			obj = proceedingJoinPoint.proceed();
		} catch (Throwable e) {

			e.printStackTrace();
		}
		logger.info("After process request and response data: {}", obj);
		return obj;
	}

	@AfterReturning(pointcut = "execution(* com.veeru.spring.controllers.EmployeeController.getEmployeeInfoById(..))", returning = "entity")
	public void AfterReturningAdviceUsage(JoinPoint join, ResponseEntity<EmployeeDTO> entity) {

		logger.info("Using after return method & called method signature: {}", join.getSignature());
		logger.info("Input value: {}", join.getArgs()[0]);
		logger.info("return obj:{}", entity);
	}

	@AfterThrowing(pointcut = "execution(* com.veeru.spring.controllers.EmployeeController.getEmployeeInfoById(..))", throwing = "objNotFoundException")
	public void AfterThrowingAdviceUage(JoinPoint join, ObjectNotFoundException objNotFoundException) {
		logger.error("Error occured Message: {} and Error Id:{}", objNotFoundException.getMessage(),
				objNotFoundException.getErrorId());
	}
}
