package org.caranus.eventticket.aspect;

import java.util.Arrays;
import java.util.Collection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("@annotation(Loggable)")
	public void executeLogging() {
		LOGGER.info("Logging pointcut triggered!");
	}
/*
	@Before("executeLogging()")
	public void logMethodCall(JoinPoint joinPoint) {
		LOGGER.info("Logging method call triggered!");
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinPoint.getSignature().getName());
		Object [] args = joinPoint.getArgs();
		if ((null != args) && (args.length > 0)) {
			message.append(" args=[ |");
			Arrays.asList(args).forEach(arg -> message.append(arg).append(" | "));
			message.append(" ] ");
		}
		LOGGER.info(message.toString());
	}

	@AfterReturning(value = "executeLogging()", returning = "returnValue")
	public void logAfterReturningMethodCall(JoinPoint joinPoint, Object returnValue) {
		LOGGER.info("Logging method call triggered!");
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinPoint.getSignature().getName());
		Object [] args = joinPoint.getArgs();
		if ((null != args) && (args.length > 0)) {
			message.append(" args=[ |");
			Arrays.asList(args).forEach(arg -> message.append(arg).append(" | "));
			message.append(" ] ");
		}
		if (returnValue instanceof Collection)
		{
			message.append(" , returning: ").append(((Collection<?>) returnValue).size()).append(" instance(s).");
		} else {
			message.append(" , returning: ").append(returnValue.toString()).append(" String.");
		}
		LOGGER.info(message.toString());
	}
*/
	@Around(value = "executeLogging()")
	public Object logAroundMethodCall(ProceedingJoinPoint joinPoint) throws Throwable
	{
		long startTime = System.currentTimeMillis();
		Object returnValue = joinPoint.proceed();
		long totalTime = System.currentTimeMillis() - startTime;
		LOGGER.info("Logging method call triggered!");
		StringBuilder message = new StringBuilder("Method: ");
		message.append(joinPoint.getSignature().getName());
		message.append(" , totalTime: ").append(totalTime).append("ms");
		Object [] args = joinPoint.getArgs();
		if ((null != args) && (args.length > 0)) {
			message.append(" args=[ |");
			Arrays.asList(args).forEach(arg -> message.append(arg).append(" | "));
			message.append(" ] ");
		}
		if (returnValue instanceof Collection)
		{
			message.append(" , returning: ").append(((Collection<?>) returnValue).size()).append(" instance(s).");
		} else {
			message.append(" , returning: ").append(returnValue.toString()).append(" String.");
		}
		LOGGER.info(message.toString());

		return returnValue;
	}
}
