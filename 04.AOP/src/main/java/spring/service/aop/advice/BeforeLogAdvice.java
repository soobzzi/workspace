package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogAdvice implements MethodBeforeAdvice{
	
	public void before(Method method, Object[] args, Object target)throws Throwable{
		//무엇을 추상화 캡슐화 했는가?
		//target. : 
		
		System.out.println("\n===================");
		System.out.println("[before LOG]" +getClass() + ".before() start...");
		System.out.println("[before LOG] tagetObject call method" +method);
		
		if(args.length != 0) {
			System.out.println("[before LOG] tagetObject method 전달 argument : "+ args[0]);
		}
		
		System.out.println("[before LOG]" +getClass()+".before() end....");
	}

}
