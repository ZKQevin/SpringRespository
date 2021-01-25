package org.example.ba06;

import org.example.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mytest06
{
    @Test
    public void text(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("ba06/applicationContext.xml");
        //从容器中获取对象
        Student student= (Student) ac.getBean("myStudent");
        System.out.println(student);
    }
}
