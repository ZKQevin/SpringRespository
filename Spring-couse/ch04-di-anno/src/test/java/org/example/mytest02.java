package org.example;

import org.example.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class mytest02
{
    @Test
    public void text(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取对象
        Student student= (Student) ac.getBean("myStudent");
        System.out.println(student.toString());
    }
}
