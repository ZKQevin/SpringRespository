package org.example.ba02;

public class Student {
    public String name;
    public int age;
    public Student(){

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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