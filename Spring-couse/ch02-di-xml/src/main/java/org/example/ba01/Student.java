package org.example.ba01;

public class Student {
    public String name;
    public int age;
    public Student(){

    }
    public void setName(String name) {
        this.name = name;
    }
    /*需要有set方法，没有set方法就会报错*/
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String Email) {
        System.out.println("Email="+Email);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}