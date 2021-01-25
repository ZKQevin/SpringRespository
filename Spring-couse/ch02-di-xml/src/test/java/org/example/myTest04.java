package org.example;

import org.example.ba04.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class myTest04 {
    @Test
    public void test04(){
        String config="ba04/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        Student file= (Student) ac.getBean("Student");
        System.out.println(file);
    }

}
