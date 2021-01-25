package org.example.ba01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
* @Aspect:是aspectj框架中的注解
* 作用：表示当前类是切面类。
* 切面类：是用来给业务类增加功能的，在这个类中有切面类的功能实现
* 位置：在类定义的上面
*
* */
@Aspect
@Component
public class MyAspect {
    /*定义方法，方法是实现切面功能的
    * 方法的定义方法要求：
    * 1、公共方法public
    * 2、方法没有返回值
    * 3、方法名称自定义
    * 4、方法可以有参数，也可以没参数。
    *   如果有参数，参数不是自定义，有几个参数类型
    * */

    /*@Before：前置通知注解
    * 属性：value，是切入点表达式，表示切面功能执行的文字
    *
    * 特点：
    *    1.在目标方法之前先执行的
    *    2.不会改变目标方法的执行结果
    *    3.不会影响目标方法的执行。
    */
    /*@Before(value = "execution(public void org.example.ba01.SomeServiceImpl.doSome(String,Integer))")//参数个数一定要一模一样不然会报错，就不会被代理
    public void myBefore(){
        Date before=new Date();
        int beforeSecond=before.getSeconds();
        System.out.println("前置通知，切面功能：输出执行时间：\n"+before);
    }*/

    /*@After(value="execution(public void org.example.ba01.SomeServiceImpl.doSome(String,Integer))")
    public void myAfter(){
        Date after=new Date();
        System.out.println("事务已经完成，提交事务。运行时间为：\n"+after);
    }*/

    /*
    * 指定通知方法的参数：JoinPoint
    * JoinPoint：业务方法，要加入切面功能的业务方法
    *   作用是：可以在通知方法中获取方法执行时信息，就加入JoinPoint
    *   这个JoinPoint参数的值由框架赋予，必须是第一个位置*/
    @Before(value = "execution(void *..SomeServiceImpl.do*(..))")/*切面表达式的简写*/
    public void myBefore(JoinPoint jp){
        Date before=new Date();
        //获取方法的完整定义
        System.out.println("方法的签名（定义）="+jp.getSignature());
        System.out.println("方法的名称="+jp.getSignature().getName());
        //获取方法的实参
        Object args []=jp.getArgs();
        for(Object arg:args){
            System.out.println("参数"+arg);
        }
        System.out.println("前置通知，切面功能：输出执行时间：\n"+before);
    }
}
