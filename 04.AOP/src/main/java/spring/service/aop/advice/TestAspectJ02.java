package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class TestAspectJ02 {
	
	public TestAspectJ02() {
		System.out.println(":: TestAspectJ01 Default Constructor");
	}
	
//	@Pointcut("execution(* *.getMessage(..))")
//	public void work() {
//		System.out.println("work() pointcut call..............");
//	}
	
	@Before("execution(* *.getMessage(..))")
	public void before(Method method, Object[] args, Object target)throws Throwable{
		//������ �߻�ȭ ĸ��ȭ �ߴ°�?
		//target. : 
		
		System.out.println("[before LOG]" +getClass() + ".before() start...");
		System.out.println("[before LOG] tagetObject call method" +method);
		
		if(args.length != 0) {
			System.out.println("[before LOG] tagetObject method ���� argument : "+ args[0]);
		}
		
		System.out.println("[before LOG]" +getClass()+".before() end....");
	}

	@Around("execution(* spring.service.aop.*.*(..))")
	public Object invoke(MethodInvocation invocation) throws Throwable {
		 
		System.out.println("[Around before]"+getClass() + ".invoke() start...");
		System.out.println("[before LOG] tagetObject call method" + invocation);
		if(invocation.getArguments().length != 0) {
			System.out.println("[Around before] tagetObject method ���� argument : "+ invocation.getArguments()[0]);
		}
		
		Object obj = invocation.proceed();
		
		System.out.println("[Around after] Ÿ�� ��ü�� ȣ���� return value :"+ obj	);
		System.out.println("[Around after]"+getClass() + ".invoke() end...");
		
		return obj;
	}

	@AfterReturning(pointcut="within(spring.service.aop..*)",returning = "returnValue")
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("[after LOG]" + getClass()+ ".afterReturning() start...");
		System.out.println("[after LOG] tagetObject call method" +method);
		System.out.println("[after LOG] Ÿ�� ��ü�� ȣ�� �� return value : "+ returnValue);
		System.out.println("[after LOG]" + getClass() + ".afterReturning() end...");
		
	}
	
	@AfterThrowing(pointcut = "execution(public * *(..))", throwing = "throwable")
	public void afterThrowing(Throwable throwable) {
		System.out.println("[exception]" + getClass()+ ".afterThrowing() start...");
		System.out.println("[exception] Exception �߻�...");
		System.out.println("[exception] Exception Message : "+ throwable.getMessage());
		System.out.println("[exception]" + getClass() + ".afterThrowing() end...");
		
	}

}
