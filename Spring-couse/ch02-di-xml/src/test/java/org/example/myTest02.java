package org.example;

import org.example.ba02.School;
import org.example.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest02 {
    /*使用传统的方法对其进行赋值对象*/
    @Test
    public void test01(){
        School school=new School();
        school.setName("重庆理工大学");
        school.setAddress("两江校区");
        Student student=new Student();
        student.setName("Kevin");
        student.setAge(18);
        student.setSchool(school);
        System.out.println(student);
    }
    /*使用spring方法中的DI注入方式进行赋值*/
    @Test
    public void test02(){
        String config="ba02/applicationContext.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建容器
        Student my_student= (Student) ac.getBean("Student");
        System.out.println(my_student);
    }
}
