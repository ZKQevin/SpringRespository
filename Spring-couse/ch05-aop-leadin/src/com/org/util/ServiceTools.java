package com.org.util;

import java.util.Date;

public class ServiceTools {
    public static void doLog(){
        System.out.println("当前业务执行时间"+new Date());
    }

    public static void doTrans(){
        //业务最后提交事务
        System.out.println("业务执行之后，提交事务");
    }
}
