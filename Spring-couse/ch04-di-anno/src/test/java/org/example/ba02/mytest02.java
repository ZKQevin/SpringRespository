package org.example.ba02;

import org.example.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mytest02 {
    @Test
    public void test(){
       ApplicationContext ac=new ClassPathXmlApplicationContext("ba03/applicationContext.xml");
       Student student= (Student) ac.getBean("myStudent");
        System.out.println(student);
    }
}
