package com.jie.reflection;


//有了Class实例，我们还可以通过getSuperclass()获取它的父类的Class：
public class InheritanceRelationship {
    public static void main(String[] args) {

        System.out.println("=================查询继承的父类============");
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());
        System.out.println();


//        一个类可能实现一个或多个接口，通过Class我们就可以查询到实现的接口类型

        System.out.println("=================查询实现的接口类型============");
        Class s = Integer.class;
        Class[] cos = s.getInterfaces();
        for (Class c : cos) {
            System.out.println(c);
        }
        System.out.println();


        System.out.println("=================查询父类实现的接口类型============");
        Class s2 = Integer.class.getSuperclass();
        Class[] fCos = s2.getInterfaces();
        for (Class fc : fCos) {
            System.out.println(fc);
        }

        System.out.println("================继承关系============");

        System.out.println("      a instanceof  b    a、b的继承关系判断a是否是b的子类============");
        Object n2 = Integer.valueOf(123);
        boolean isDouble = n2 instanceof Double; // false
        System.out.println(isDouble);
        boolean isInteger = n2 instanceof Integer; // true
        System.out.println(isInteger);
        boolean isNumber = n2 instanceof Number; // true
        System.out.println(isNumber);
        boolean isSerializable = n2 instanceof java.io.Serializable; // true
        System.out.println(isSerializable);


        System.out.println("      a.isAssignableFrom(b)    a、b的继承关系判断a是否是b的父类============");

        // Integer i = ?
        System.out.println(Integer.class.isAssignableFrom(Integer.class));// true，因为Integer可以赋值给Integer
        // Number n = ?
        System.out.println(Number.class.isAssignableFrom(Integer.class));// true，因为Integer可以赋值给Number
        // Object o = ?
        System.out.println(Object.class.isAssignableFrom(Integer.class));// true，因为Integer可以赋值给Object
        // Integer i = ?
        System.out.println(Integer.class.isAssignableFrom(Number.class));// false，因为Number不能赋值给Integer
    }
}
