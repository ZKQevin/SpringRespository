package org.example.ba05;

import org.springframework.stereotype.Component;

@Component("SomeServiceImpl")
public class SomeServiceImpl implements SomeService {
    @Override
    //目标类
    public void doSome(String name, Integer age) {
        //给doSome的方法增加一些功能，执行之前，输出方法的执行时间
        System.out.println("目标方法doSome");

    }
    @Override
    public String doOther(String name, Integer age) {
        System.out.println("目标方法doOther()");
        return "abcd";
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("业务方法doFirst");
        return "环绕通知";
    }

    @Override
    public void doSecond() {
        System.out.println("执行业务方法doSecond()"+(10/0));
    }

    @Override
    public void doThird() {
        System.out.println("执行doThird()方法"+(10/0));
    }
}
