package org.example;

import org.example.domin.SysUser;
import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class AppTest 
{
    @Test
    public void test(){
        //从spring容器中获取userService类型的对象，dao，service都是spring管理
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
                UserService service= (UserService) ac.getBean("userService");
        SysUser user=new SysUser();
        user.setName("Kevin");
        user.setAge(20);
        service.addUser(user);
    }
    @Test
    public void test01(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        Date date= (Date) ac.getBean("Date");
        System.out.println(date);
    }
}
