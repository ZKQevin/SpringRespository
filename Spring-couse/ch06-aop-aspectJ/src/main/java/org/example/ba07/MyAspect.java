package org.example.ba07;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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

    @After(value="mypt()")
    public void myAfter(){
        System.out.println("执行最终通知，总是会被执行");
        //一般做资源清除工作的。
    }

    @Before(value="execution(* * ..SomeServiceImpl.doThird(..))")
    public void myBefore(){
        System.out.println("前置通知，在目标方法之前执行的");
        //一般做资源清除工作的。
    }

    /*
    * @Pointcut：定义和管理切入点，如果你的项目有多个切入点表达式是重复的复用的，
    *               可以使用@Pointcut进行定义
    *   属性：value    切入点表达式
    *   位置：自定义位置
    * 特点：
    *   当使用@Pointcut定义在一个方法的上面，此时这个方法的名称就是切入点表达式的别名
    *   其它的通知中，value属性就可以使用这个方法的名称，代替切入点表达式。
    *
    * */
    @Pointcut(value="execution(* * ..SomeServiceImpl.doThird(..))")
    private void mypt(){
        //无需代码
    }
}
