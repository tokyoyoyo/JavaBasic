package com.jie.reflection;
//反射的目的是为了获得某个实例的信息
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Number n = new Double(123.456); // OK
//        String s = new Double(123.456); // compile error!


//        类的实例在JVM中是唯一的，所以，三种方法获取的Class实例是同一个实例
//        方法一：直接通过一个class的静态变量class获取：
        Class cls = String.class;

//        方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取：
        String s = "Hello";
        Class cls2 = s.getClass();

//        方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
        Class cls3 = Class.forName("java.lang.String");

        boolean sameClass = cls == cls2; // true

        Integer n2 = new Integer(123);

//        instanceof不但匹配指定类型，还匹配指定类型的子类。
//        用==判断class实例可以精确地判断数据类型，但不能作子类型比较
        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
        boolean b2 = n instanceof Number; // true，因为n是Number类型的子类

        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
        boolean b4 = n.getClass() == Number.class; // false，因为Integer.class!=Number.class


        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);

    }

    static void printClassInfo(Class cls) {     //取该Object的class信息
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }

}

        /*

                除了int等基本类型外，Java的其他类型全部都是class（包括interface）。
                仔细思考，我们可以得出结论：class（包括interface）的本质是数据类型（Type）。

                无继承关系的数据类型无法赋值：
                    Number n = new Double(123.456); // OK
                    String s = new Double(123.456); // compile error!

                JVM在第一次读取到一种类时，将其加载进内存。并为其创建一个Class类型的实例
                public final class Class {
                    private Class() {}
                }

                Class实例包含了对应类的信息

                // 获取String的Class实例:
                Class cls = String.class;
                // 创建一个String实例:
                String s = (String) cls.newInstance();      //当于new String()

        */