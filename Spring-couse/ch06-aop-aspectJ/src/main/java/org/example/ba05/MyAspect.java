package org.example.ba05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
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
    /*异常通知
    * 1.public
    * 2.没有返回值
    * 3.方法名称自定义
    * 4.方法可以有一个Exception，如果还有有就是JoinPotint
    * */

    /*
    * 最终通知方法的定义修饰
    * @After:最终通知
    * 属性：value  切入点表达式
    * 位置：在方法的上面
    * 特点：
    * 1.总是会执行
    * 2.在目标方法后政治性的
    *类似于try{SomeSeriveImpl.doThird()}catch{}finally{myAfter}
    * */
    @After(value="execution(* * ..SomeServiceImpl.doThird(..))")
    public void myAfter(){
        System.out.println("执行最终通知，总是会被执行");
        //一般做资源清除工作的。
    }
}
