package com.jie.reflection;

public class StaticProxy {

    public static void main(String[] args) {
//        创建实例，转型为接口并调用：
        Hello hello = new HelloWorld();
        hello.morning("Bob");

    }
}


//编写实现类：
class HelloWorld implements Hello {
    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }
}