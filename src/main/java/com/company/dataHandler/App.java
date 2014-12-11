package com.company.datahandler;

import java.io.IOException;
import java.util.Arrays;

import org.apache.mina.core.service.IoAcceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Let's inspect the beans provided by Spring:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        //IoAcceptor acceptor= (IoAcceptor) ctx.getBean("ioAcceptor");
        //acceptor.bind();
        while (true) {
			
		}
    }
}
