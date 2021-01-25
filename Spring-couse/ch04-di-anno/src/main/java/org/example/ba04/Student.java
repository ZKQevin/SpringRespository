package org.example.ba04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myStudent")
public class Student {
    @Value(value="Kevin")
    private String name;
    @Value(value="20")
    private Integer age;
    /*引用类型
    * @Autowired：spring框架提供的注解，采用引用类型的赋值
    * spring中通过注解给引用类型赋值，使用的是自动注入的原理，支持byName，byType
    * @Autowired:默认使用byType自动注入。
    *
    *   位置：1）在属性定义的上面，无需set方法，推荐使用
    *        2）在set方法的上面
    *   如果使用byName的方法，需要做的是：
    *   1.在属性上面加入@Autowired
    *   2.在属性上面加入@Qualifier(value="bean的id")：表示指定bean的名称*/
    @Autowired()
//    byName的自动注入
    @Qualifier("mySchool")
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
