package org.example.ba06;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "myStudent")
public class Student {
    @Value(value="Kevin")
    private String name;
    @Value(value="25")
    /*引用类型
    * @Resource：来自jdk中的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
    *            使用的也是自动注入原理，支持byName，byType，默认是byName
    * 位置：1.在属性定义的上面，无需set方法，推荐使用
    *      2.在set方法的上面
    * */
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
