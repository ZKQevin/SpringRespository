package org.example;

import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class myTest {
    @Test
    public void test01(){
        SomeService service=new SomeServiceImpl();
        service.doSome();
    }
    /*Spring默认创建对象的时间：在创建容器时，默认会创建bean中所有的对象*/
    @Test
    public void test02(){
        //使用spring容器创建的对象
        //1.指定spring配置文件的名称
        String config="beans.xml";
        //2.创建表示spring容器的对象，ApplicationContext
        //ApplicationContext就是表示Spring容器，通过这个容器对象，就可以使用对象了（获取对象）
        //ClassPathXMLApplicationContext：表示从类路径中加载spring配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);//创建好了容器（执行这条语句之后便会创建config中的对象）

        //从容器中获取某个对象，你要调用对象的方法
        //getbean("配置文件的ID值")方法通过id拿到对象
        SomeService service= (SomeService) ac.getBean("someService1");//强制转换为service类型
        //使用spring创建好的对象
        service.doSome();
    }

    /*获取Spring容器中java对象的信息*/
    @Test
    public void test03(){
        String config="beans.xml";//默认获取target下类文件中ort下的beans.xml文件
        ApplicationContext ac=new ClassPathXmlApplicationContext(config);
        int number=ac.getBeanDefinitionCount();//获取默认id中的数量
        System.out.println("容器中对象的数量为："+number);
        String names[]=ac.getBeanDefinitionNames();//获取容器中的id名称
        for(String name:names){//遍历names中的数组名称
            System.out.println(name);
        }
    }
    /*创建一个日期对象
    * spring创建对象：默认调用的是无参数的构造方法！
    * */
    @Test
    public void test04(){
       ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
       Date my_date= (Date) ac.getBean("my_date");//通过id获取到my_date的对象
        System.out.println("当前时间为"+my_date);
    }
}
