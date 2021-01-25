package org.example;

import org.example.domin.SysUser;
import org.example.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring-zhujie.xml");
        UserServiceImpl service= (UserServiceImpl) ac.getBean("service");
        SysUser user=new SysUser();
        user.setName("Kevin");
        user.setAge(20);
        service.addUser(user);
    }
}   