package com.jie.inner;

public class StsticClass {
    public static void main(String[] args) {
        Outer2.StaticNested sn = new Outer2.StaticNested();
        sn.hello();
    }
}

class Outer2 {
    private static String NAME = "OUTER";

    private String name;

    Outer2(String name) {
        this.name = name;
    }

    static class StaticNested {
//        用static修饰的内部类和Inner Class有很大的不同，它不再依附于Outer的实例，而是一个完全独立的类，
//        因此无法引用Outer.this，但它可以访问Outer的private静态字段和静态方法,
//        如果把StaticNested移到Outer之外，就失去了访问private的权限
        void hello() {
            System.out.println("Hello, " + Outer2.NAME);
        }
    }

}

//    Inner Class和Anonymous Class本质上是相同的，都必须依附于Outer Class的实例，
//    即隐含地持有Outer.this实例，并拥有Outer Class的private访问权限；


//    Static Nested Class是独立类，但拥有Outer Class的private访问权限。