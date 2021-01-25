package org.example.ba01;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component:创建对象，等同于<bean></bean>的功能
 *  属性value=就是对象的名称，也就是bean的id值
 *     value值是唯一的，创建的对象在整个Spring容器中就一个
 *  位置：在类的上面
 *  1.@Repository（用在持久层类上面）：放在dao的实现类上面，表示创建dao对象，dao对象是能访问数据库的。
 *  2.@Service（用在业务层类的上面）：放在service的实现类上面，创建service对象，ser对象是做业务处理，可以有事务功能的。
 *  3.@Controller（放在控制器的上面的）：放在控制器（处理器）类的上面，创建控制对象，控制器对象，能够接受用户用户提交的参数，显示情趣的处理结果
 *      以上三个注解的适用语法和Component是一样的。都能够创建对象，但是这三个注解还有额外的功能。。
 *  @Repository，@Service，@Controller是给项目分层的。分别为持久层，业务层，控制层。
 *  @Component不确定是其它三个就可以用Component。普通类
 */
@Component(value = "myStudent")
//可以省略Value直接@Component("myStudent")
public class Student {
    /*@Value:简单类型的属性赋值
    *   属性：value是String类型的，表示简单类型的属性值
    *   位置：1.在属性定义的上面，无需要set方法，推荐使用
    *        2.在set方法上面*/
    @Value(value="Kevin")
    private String name;
    @Value(value="20")
    private Integer age;
    public Student(){
        System.out.println("使用无参构造方法");
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
