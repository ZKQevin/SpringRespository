package org.example.ba02;

import org.springframework.stereotype.Component;

@Component("SomeServiceImpl")
public class SomeServiceImpl implements SomeService {
    @Override
    //目标类
    public void doSome(String name, Integer age) {
        //给doSome的方法增加一些功能，执行之前，输出方法的执行时间
        System.out.println("目标方法doSome");

    }
    @Override
    public String doOther(String name, Integer age) {
        System.out.println("目标方法doOther()");
        return "abcd";
    }
    @Override
    public Student doStudent(String name,Integer age){
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }
}
