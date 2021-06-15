package com.jie.inner;

public class Outer {
    public static void main(String[] args) {
        Outer outer = new Outer("Nested"); // 实例化一个Outer
        outer.new Inner().hello(); // 实例化一个Inner
//        Inner Class除了有一个this指向它自己，还隐含地持有一个Outer Class实例，
//        可以用Outer.this访问这个实例。所以，实例化一个Inner Class不能脱离Outer实例。

//        Inner Class的作用域在Outer Class内部，所以能访问Outer Class的private字段和方法

    }

    private String name;

    Outer(String name) {
        this.name = name;
    }
//    Outer是一个普通类，而Inner是一个Inner Class，它与普通类有个最大的不同，
//    Inner Class的实例不能单独存在，必须依附于一个Outer Class的实例

    class Inner {
        // 定义了一个Inner Class
        void hello() {
            System.out.println("Hello, " + Outer.this.name);
        }
    }
}
