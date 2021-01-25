package org.example.ba05;

import org.example.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mytest05 {
    @Test
    public void test(){
       ApplicationContext ac=new ClassPathXmlApplicationContext("ba05/applicationContext.xml");
       Student student= (Student) ac.getBean("myStudent");
        System.out.println(student);
    }
}
