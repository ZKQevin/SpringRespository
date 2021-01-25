package org.example.service.impl;

import org.example.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl(){
        System.out.println("SomeServiceImpl无参数的构造方法");
    }
    @Override
    public void doSome() {
        System.out.println("执行了SomeserviceImpl的方法");
    }
}
