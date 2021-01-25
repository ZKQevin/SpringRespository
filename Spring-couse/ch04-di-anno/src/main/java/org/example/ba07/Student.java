package org.example.ba07;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "myStudent")
public class Student {
    /*使用${}的方式来赋值*/
    @Value("${myName}")
    private String name;
    @Value("${myAge}")
    private Integer age;
    //默认使用byName，如果byName失败就会使用byType
    @Resource
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

}
