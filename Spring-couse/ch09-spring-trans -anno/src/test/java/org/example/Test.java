package org.example;

import org.example.service.BuyGoodsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test01(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取Service
        BuyGoodsService service = (BuyGoodsService) ctx.getBean("buyService");
        //调用方法
        /*com.sun.proxy.$Proxy16是JDK的动态代理*/
        System.out.println("service是代理："+service.getClass().getName());
        service.buy(1001,10);
    }
}
