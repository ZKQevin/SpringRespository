package org.example;

import org.example.ba07.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test07 {

    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeServiceImpl service= (SomeServiceImpl) ac.getBean("SomeServiceImpl");
        //通过代理的对象执行方法，实现目标方法执行时，增强了功能
        //没有接口那么他就是Spring下的cglib代理，有接口就是JDK的动态代理
        System.out.println("proxy:"+service.getClass());

        service.doThird();
        //System.out.println(str);
        
    }

}
