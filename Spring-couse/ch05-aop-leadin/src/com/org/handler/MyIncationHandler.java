package com.org.handler;

import com.org.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIncationHandler implements InvocationHandler {
    private Object target;
    public MyIncationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过代理对象执行方法时，会调用执行这个invake()
        //执行目标类的方法，通过Method类实现
        Object res=null;
        ServiceTools.doLog();
        res=method.invoke(target,args);//SomeServiceImpl中doSome和doOther方法
        ServiceTools.doTrans();
        return res;
    }
}
