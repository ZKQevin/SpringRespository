package org.example.ba02;

import org.aspectj.lang.annotation.AfterReturning;
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
    /*猴子通知定义方法
     * 方法的定义方法要求：
     * 1、公共方法public
     * 2、方法没有返回值
     * 3、方法名称自定义
     * 4、方法可以有参数，也可以没参数。
     *   如果有参数，参数不是自定义，有几个参数类型
     * */
    /*
    * @AfterReturning:后置通知
    * 属性：1.value切入点表达式
    *       2.returning 自定义的变量，表示目标方法的返回值的。
    *           自定义变量名必须和通知方法的星灿明一样
    * 位置：在方法定义的上面
    * 特点：
    *   1.在目标方法之后执行
    *   2.能够获取到目标的返回值，可以根据这个返回值做不同的处理功能
    *   3.可以修改这个返回值
    *
    * 后置通知的执行
    *   Object res=doOther();
    *   myAfterReturning(res);
    */

    @AfterReturning(value="execution(* org.example.ba02.SomeServiceImpl.doOther(String,Integer))",
            returning = "res")/*需要保证和方法中的参数是一样的returning名字*/
    public void myAfterReturning(Object res){
        //Object res:是目标方法执行后的返回值，根据返回值做你的切面的功能处理
        System.out.println("后置通知：目标方法后执行，获取的返回值为"+res);
        if(res.equals("abcd")){
            //做一些功能
        }else{
            //做其它功能
        }
        if(res!=null){
            res="Hello AspectJ";
        }
    }
    @AfterReturning(value="execution(* org.example.ba02.SomeServiceImpl.doStudent(String,Integer))",
            returning = "student")/*需要保证和方法中的参数是一样的returning名字*/
    public void myAfterReturningstudent( Object student){
        //Object res:是目标方法执行后的返回值，根据返回值做你的切面的功能处理
        Student student1=new Student("张凯淇",16);

        student=student1;

    }

}
