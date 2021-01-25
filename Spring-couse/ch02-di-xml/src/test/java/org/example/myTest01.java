package org.example;

import org.example.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


public class myTest01 {
    /*创建对象没有进行赋值*/
    @Test
    public void test01(){
        String config="ba01/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        Student student= (Student) ac.getBean("Student01");//拿到Student对象
        System.out.println("Student对象"+student);//没有进行赋值，所以是null和0的
    }
    /*使用DI注入set方法进行赋值*/
    @Test
    public void test02(){
        String config="ba01/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        Student my_student= (Student) ac.getBean("Student02");//拿到Student对象
        System.out.println("Student对象"+my_student);//xml进行di注入set方法赋值
        my_student.setAge(20);//重新设置年龄
        System.out.println("重新设置的Student对象"+my_student);
    }
//    给默认的Date进行set赋值
    @Test
    public void test03(){
        String config="ba01/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        Date my_date= (Date) ac.getBean("my_date");
        System.out.println(my_date);
    }
}