package org.example;

import org.example.dao.StudentDao;
import org.example.entity.Student;
import org.example.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class myTest {
    @Test
    public void test01(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        String names[]=ctx.getBeanDefinitionNames();
        for(String na:names){
            //可以看到利用Mybatis单独创建的SqlSessionFactory进行创建的
            System.out.println("容器中对象的名称"+na+"|"+ctx.getBean(na));

        }
    }

    @Test
    public void testDaoInsert(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
        System.out.println(studentDao);
        Student student=new Student();
        student.setId(1005);
        student.setName("张三");
        student.setEmail("15615616@qq.com");
        student.setAge(20);
        int num=studentDao.insertStudent(student);
        System.out.println("nums="+num);

    }

    @Test
    public void testServiceInsert(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        Student student=new Student();
        student.setId(1007);
        student.setName("张三");
        student.setEmail("15615616@qq.com");
        student.setAge(20);
        int num=studentService.addStudent(student);
        //spring和mybatis集合在一起使用，事务是自动提交的。无需执行SqlSession.commit()（事务提交）
        System.out.println("nums="+num);
    }

    @Test
    public void testServiceSelect(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) ctx.getBean("studentService");
        List<Student> students = studentService.queryStudents();
        for (Student student:students){
            System.out.println(student);
        }

    }
}
