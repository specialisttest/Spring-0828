package ru.specialist.AOP;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MessageWriter target = new MessageWriter();
        //System.out.printf("writeMessage() result: %s\n", 
        //		target.writeMessage());
        //target.printMessage();
    	
    	
        /*
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MessageDecorator());
        pf.setTarget(target);
        
        MessageWriter proxy = (MessageWriter)pf.getProxy();
        
        
        System.out.printf("writeMessage() result: %s\n", 
        		proxy.writeMessage());
        proxy.printMessage();
        */
        
        /*
        System.out.println(proxy.getClass().getName());
        System.out.println(proxy instanceof MessageWriter);
        */
    	
        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new MessageDecorator();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(target);
        MessageWriter proxy = (MessageWriter)pf.getProxy();
        
        proxy.writeMessage();
        proxy.printMessage();
        
        System.out.println(proxy.getClass().getName());
        System.out.println(proxy instanceof MessageWriter);
        
    }
}
