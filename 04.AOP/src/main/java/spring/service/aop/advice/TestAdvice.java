package spring.service.aop.advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class TestAdvice implements MethodBeforeAdvice,
									AfterReturningAdvice,
									ThrowsAdvice,
									MethodInterceptor{
	
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

	@Override
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

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("[after LOG]" + getClass()+ ".afterReturning() start...");
		System.out.println("[after LOG] tagetObject call method" +method);
		System.out.println("[after LOG] Ÿ�� ��ü�� ȣ�� �� return value : "+ returnValue);
		System.out.println("[after LOG]" + getClass() + ".afterReturning() end...");
		
	}
	
	public void afterThrowing(Throwable throwable) {
		System.out.println("[exception]" + getClass()+ ".afterThrowing() start...");
		System.out.println("[exception] Exception �߻�...");
		System.out.println("[exception] Exception Message : "+ throwable.getMessage());
		System.out.println("[exception]" + getClass() + ".afterThrowing() end...");
		
	}

}
