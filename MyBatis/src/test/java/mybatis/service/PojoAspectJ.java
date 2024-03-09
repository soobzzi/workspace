package mybatis.service;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class PojoAspectJ {
	
	public PojoAspectJ() {
		System.out.println(":: PojoAspectJ Default Constructor");
	}
	
//	@Pointcut("execution(* *.getMessage(..))")
//	public void work() {
//		System.out.println("work() pointcut call..............");
//	}
	

	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		 
		System.out.println("[Around before]"+getClass() + ".invoke() start...");
		System.out.println("[before LOG]  ≈∏∞Ÿ ∞¥√º" + joinPoint.getTarget().getClass().getName());
		System.out.println("[before LOG] ≈∏∞Ÿ ∞¥√º¿« »£√‚µ… method : " +joinPoint.getSignature().getName());
		
		if(joinPoint.getArgs().length != 0) {
			System.out.println("[Around before] tagetObject method ¿¸¥ﬁ argument : "+ joinPoint.getArgs()[0]);
		}
		
		Object obj = joinPoint.proceed();
		
		System.out.println("[Around after] ≈∏∞Ÿ ∞¥√º¿« »£√‚»ƒ return value :"+ obj	);
		System.out.println("[Around after]"+getClass() + ".invoke() end...");
		
		return obj;
	}


}
