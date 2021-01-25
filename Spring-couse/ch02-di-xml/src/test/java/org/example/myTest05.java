package org.example;

import org.example.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest05 {
    @Test
    public void test04(){
        String config="ba05/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        Student file= (Student) ac.getBean("Student");
        System.out.println(file);
    }
}
