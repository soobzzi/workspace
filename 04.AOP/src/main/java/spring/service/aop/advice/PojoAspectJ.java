package spring.service.aop.advice;

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
	
	public void before(JoinPoint joinPoint){
		
		
		System.out.println("[before LOG]" +getClass() + ".before() start...");
		System.out.println("[before LOG] Ÿ�� ��ü : " + joinPoint.getTarget().getClass().getName());
		System.out.println("[before LOG] Ÿ�� ��ü�� ȣ��� method : " +joinPoint.getSignature().getName());
		
		if(joinPoint.getArgs().length != 0) {
			System.out.println("[before LOG] Ÿ�� ��ü�� ȣ���� method�� ���޵Ǵ� argument : "+ joinPoint.getArgs()[0]);
		}
		
		System.out.println("[before LOG]" +getClass()+".before() end....");
	}

	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		 
		System.out.println("[Around before]"+getClass() + ".invoke() start...");
		System.out.println("[before LOG]  Ÿ�� ��ü" + joinPoint.getTarget().getClass().getName());
		System.out.println("[before LOG] Ÿ�� ��ü�� ȣ��� method : " +joinPoint.getSignature().getName());
		
		if(joinPoint.getArgs().length != 0) {
			System.out.println("[Around before] tagetObject method ���� argument : "+ joinPoint.getArgs()[0]);
		}
		
		Object obj = joinPoint.proceed();
		
		System.out.println("[Around after] Ÿ�� ��ü�� ȣ���� return value :"+ obj	);
		System.out.println("[Around after]"+getClass() + ".invoke() end...");
		
		return obj;
	}

	public void afterReturning(JoinPoint joinPoint, Object returnValue)  throws Throwable {
		System.out.println("[after LOG]" + getClass()+ ".afterReturning() start...");
		System.out.println("[before LOG]  Ÿ�� ��ü" + joinPoint.getTarget().getClass().getName());
		System.out.println("[before LOG] Ÿ�� ��ü�� ȣ��� method : " +joinPoint.getSignature().getName());
		System.out.println("[after LOG] Ÿ�� ��ü�� ȣ�� �� return value : "+ returnValue);
		System.out.println("[after LOG]" + getClass() + ".afterReturning() end...");
		
	}
	
	public void afterThrowing(JoinPoint joinPoint,Throwable throwable) {
		System.out.println("[exception]" + getClass()+ ".afterThrowing() start...");
		System.out.println("[before LOG]  Ÿ�� ��ü" + joinPoint.getTarget().getClass().getName());
		System.out.println("[before LOG] Ÿ�� ��ü�� ȣ��� method : " +joinPoint.getSignature().getName());
		System.out.println("[exception] Exception �߻�...");
		System.out.println("[exception] Exception Message : "+ throwable.getMessage());
		System.out.println("[exception]" + getClass() + ".afterThrowing() end...");
		
	}

}
