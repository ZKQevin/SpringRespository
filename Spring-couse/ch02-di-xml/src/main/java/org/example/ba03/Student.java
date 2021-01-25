package org.example.ba03;

public class Student {
    public String name;
    public int age;
    public School school;
    /*创建一个有参数的构造方法*/
    public Student(School school,String name,int age){
        this.school = school;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}