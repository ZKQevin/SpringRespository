package org.example.ba04;

import org.example.ba04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mytest04 {
    @Test
    public void test(){
       ApplicationContext ac=new ClassPathXmlApplicationContext("ba04/applicationContext.xml");
       Student student= (Student) ac.getBean("myStudent");
        System.out.println(student);
    }
}
