package org.example;

import org.example.ba05.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test05 {

    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService service= (SomeService) ac.getBean("SomeServiceImpl");
        //通过代理的对象执行方法，实现目标方法执行时，增强了功能
        service.doThird();
        //System.out.println(str);
        
    }

}
