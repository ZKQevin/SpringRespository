package org.example;

import org.example.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class myTest03 {
    /*使用spring方法中构造方法name属性注入赋值*/
    @Test
    public void test03(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        Student my_student= (Student) ac.getBean("Student_name");
        System.out.println(my_student);
    }
    /*使用spring方法中构造方法name属性注入赋值*/
    @Test
    public void test_index(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        Student my_student= (Student) ac.getBean("Student_index");
        System.out.println(my_student);
    }
    @Test
    public void test04(){
        String config="ba03/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        File file= (File) ac.getBean("File");
        System.out.println(file);
    }

}
