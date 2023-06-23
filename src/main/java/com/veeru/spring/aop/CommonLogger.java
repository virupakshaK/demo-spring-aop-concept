/**
 * 
 */
package com.veeru.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.veeru.spring.dto.EmployeeDTO;


/**
 * @author Virupaksha K
 *
 */

@Aspect
@Component
public class CommonLogger {

	Logger logger = LoggerFactory.getLogger(CommonLogger.class);

	@Pointcut("execution(* com.veeru.spring.controllers.*.getMessage(..))")
	public void printRequest() {

	}

	@Before("printRequest()")
	public void beforeMethodCall() {

		logger.info("Request object reached controller");
	}

	@After("printRequest()")
	public void afterMethodCall() {
		logger.info("Respose object from the controller after method return value");
	}

	@Pointcut("execution(* com.veeru.spring.controllers.EmployeeController.saveEmployee(..))")
	public void anotherPointcut() {

	}

	@Around("anotherPointcut()")
	public Object aroundAdviceUsage(ProceedingJoinPoint proceedingJoinPoint) {
		logger.info("Before request process:" + proceedingJoinPoint.getArgs()[0]);

		Object obj = null;
		try {
			obj = proceedingJoinPoint.proceed();
		} catch (Throwable e) {

			e.printStackTrace();
		}
		logger.info("After process request and response data:" + obj);
		return obj;
	}
	
	@AfterReturning(pointcut = "execution(* com.veeru.spring.controllers.EmployeeController.getEmployeeInfoById(..))", returning = "emp")
	public void AfterReturningAdviceUsage(EmployeeDTO emp) {
		logger.info("After return value:"+emp);
		
	}
}
