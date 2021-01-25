package org.example;

import org.example.ba02.SomeService;
import org.example.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test02 {

    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService service= (SomeService) ac.getBean("SomeServiceImpl");
        //通过代理的对象执行方法，实现目标方法执行时，增强了功能
        Student student = service.doStudent("Kevin", 20);
        System.out.println(student);
    }

}
