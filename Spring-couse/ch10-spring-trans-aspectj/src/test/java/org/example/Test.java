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
        //service是代理：com.sun.proxy.$Proxy12
        System.out.println("service是代理："+service.getClass().getName());
        //调用方法
        service.buy(1001,1);
    }
}
