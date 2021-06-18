package com.jie.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
//通过反射读写字段是一种非常规方法，它会破坏对象的封装。
public class AccessFieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class stdClass = Student.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));
        System.out.println();

        System.out.println("=================用反射获取该字段信息===============");

//        一个Field对象包含了一个字段的所有信息：
//
//        getName()：返回字段名称，例如，"name"；
//        getType()：返回字段类型，也是一个Class实例，例如，String.class；
//        getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。

        Field f = String.class.getDeclaredField("value");
        f.getName(); // "value"
        f.getType(); // class [B 表示byte[]类型
        int m = f.getModifiers();
        System.out.println(Modifier.isFinal(m));// true
        System.out.println(Modifier.isPublic(m));// false
        System.out.println(Modifier.isProtected(m));// false
        System.out.println(Modifier.isPrivate(m));// true
        System.out.println(Modifier.isStatic(m));// false
        System.out.println();

        System.out.println("=================用反射获取该字段值===============");

        Object p = new Person("Xiao Ming");
        Class c = p.getClass();

        Field f2 = c.getDeclaredField("name");
//        f2.setAccessible(true);
        Object value = f2.get(p);
        System.out.println(value); // "Xiao Ming"

//        name被定义为一个private字段，正常情况下，Main类无法访问Person类的private字段。
//        要修复错误，可以将private改为public，或者，在调用Object value = f.get(p);前，
//        先写一句：f2.setAccessible(true);

        System.out.println("=================用反射设置字段值===============");
        Person p2 = new Person("Xiao Ming");
        System.out.println(p2.getName()); // "Xiao Ming"
        Class c2 = p2.getClass();
        Field f3 = c2.getDeclaredField("name");
        f3.setAccessible(true);
        f3.set(p2, "Xiao Hong");
        System.out.println(p2.getName()); // "Xiao Hong"

    }
}
class Student extends Person {
    public int score;
    private int grade;

    public int getScore(String type) {
        return 99;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int getGrade(int year) {
        return 1;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void hello() {
        System.out.println("Student:hello");
    }

    public Student() {

    }

    public Student(String name, int score, int grade) {
        super(name);
        this.score = score;
        this.grade = grade;
    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person() {
    }

    public void hello() {
        System.out.println("Person:hello");
    }

    private void setName(String name) {
        this.name = name;
    }
}