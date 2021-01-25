package org.example;

import org.example.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest06 {
    @Test
    public void test06(){
        String config= "ba06/total.xml";
        /*加载总的spring-total文件*/
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        Student file= (Student) ac.getBean("Student");
        System.out.println(file);
    }
}
