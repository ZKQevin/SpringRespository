package org.example.ba01;

import org.springframework.stereotype.Component;

@Component("SomeServiceImpl")
public class SomeServiceImpl implements SomeService{
    @Override
    //目标类
    public void doSome(String name, Integer age) {
        //给doSome的方法增加一些功能，执行之前，输出方法的执行时间
        System.out.println("目标方法doSome");

    }
}
