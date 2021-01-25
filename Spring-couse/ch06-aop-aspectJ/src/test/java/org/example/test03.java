package org.example;

import org.example.ba03.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test03 {

    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService service= (SomeService) ac.getBean("SomeServiceImpl");
        //通过代理的对象执行方法，实现目标方法执行时，增强了功能
        String str = service.doFirst("zhangsan", 20);//如果不是zhangsan就会不执行doFirst
        System.out.println(str);
        
    }

}
