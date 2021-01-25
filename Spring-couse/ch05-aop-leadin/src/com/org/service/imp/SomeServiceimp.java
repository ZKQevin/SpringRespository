package com.org.service.imp;

import com.org.service.SomeService;
//Serviceimp原来的代码不修改，增加输出时间和输出日志
public class SomeServiceimp implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行doSome");
    }

    @Override
    public void doOther() {
        System.out.println("执行doOther");
    }
}
