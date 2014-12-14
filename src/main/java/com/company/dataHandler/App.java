package com.company.datahandler;

import java.io.IOException;
import java.util.Arrays;

import org.apache.mina.core.service.IoAcceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	if (System.getProperty("com.sun.management.jmxremote") != null) {
            System.out.println("JMX enabled.");
        } else {
            System.out.println("JMX disabled. Please set the "
                  + "'com.sun.management.jmxremote' system property to enable JMX.");
        }
        ApplicationContext ctx=getApplicationContext();
        
        System.out.println("Let's inspect the beans provided by Spring:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        
        System.out.println("Listening ...");
    }
    public static ConfigurableApplicationContext getApplicationContext() {
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
