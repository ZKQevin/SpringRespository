package org.example.ba07;

import org.springframework.stereotype.Component;

@Component("SomeServiceImpl")
public class SomeServiceImpl{

    public void doThird() {
        System.out.println("执行doThird()方法");
    }
}
