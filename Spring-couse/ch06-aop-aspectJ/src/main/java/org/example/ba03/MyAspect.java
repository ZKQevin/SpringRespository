package org.example.ba03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
    /*@Around:环绕通知
    属性: value切入点表达式位置:在方法的定义什么特点:
            1.它是功能最强的通知
            2.在目标方法的前和后都能增强功能。
            3.控制目标方法是否被调用执行
            4.修改原来的目标方法的执行结果。影响最后的调用结果

            环绕通知，等同于JDK的动态代理，
            参数：ProceedingJoinPoint 等同于Method
                 作用：执行目标方法的
             返回值：就是目标方法的执行结果，可以被修改
             环绕通知：经常做事务，在目标方法之前开启事务，执行目标方法，在目标方法之后提交事务

             */


    @Around(value="execution(* org.example.ba03.SomeServiceImpl.doFirst(String,Integer))")/*需要保证和方法中的参数是一样的returning名字*/
    public Object myAfterReturning(ProceedingJoinPoint pjp) throws Throwable{
        //实现环绕通知
        //进行判断是否执行方法
        String s="";
        Object[] args = pjp.getArgs();
        if(args!=null&&args.length>1){
            Object name=args[0];
            s = (String) name;
        }
        Object result=null;
        System.out.println("环绕通知：方法之前，输出时间"+new Date());
        //1.目标方法调用
        if ("zhangsan".equals(s)){
            //利用环绕通知进行方法的实现，是否调用原方法
            result=pjp.proceed();//method.invoke();Object result=doFirst();
        }
        System.out.println("环绕通知：在目标方法之后，提交事务");
        //2.在目标方法的前或后加入功能

        //修改目标方法的执行结果，影响方法最后的调用结果
        if(result!=null){
            result="Hello Aspect";
        }

        //返回目标方法的执行结果
        return result;
    }

}
