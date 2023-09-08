package ru.specialist.AOP;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class MessageDecorator implements 
//MethodBeforeAdvice 
//AfterReturningAdvice
MethodInterceptor
{
	
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.printf("INFO: execute method %s for object %s\n",
				invocation.getMethod().getName(), invocation.getThis());
		System.out.print("Hello ");
		
		Object retVal = invocation.proceed();
		//Object retVal = null;
		System.out.println("!");
		//System.out.println("Миру МИР!");
		
		System.out.printf("INFO: succefully execute method %s for object %s with return: %s\n",
				invocation.getMethod().getName(), invocation.getThis(), retVal);
		
		return retVal;
	}

	/*@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("INFO: succefully execute method %s for object %s with return: %s\n",
				method.getName(), target, returnValue);
	}*/

	/*@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.print("Hello ");
		//System.out.printf("INFO: execute method %s for object %s\n",
		//		method.getName(), target);
		//if (method.getName().contains("write"))
		//	throw new RuntimeException("Can't call write method");
		
	}*/

}
