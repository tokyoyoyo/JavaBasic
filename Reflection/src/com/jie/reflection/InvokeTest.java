package com.jie.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        System.out.println("===================过Class实例获取所有Method信息============");
        Class stdClass = Student.class;
        // 获取public方法getScore，参数为String:
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName"));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));


        System.out.println("===============用反射来调用substring方法=============");
        // String对象:
        String s = "Hello world";
        // 获取String substring(int)方法，参数为int:
        Method m = String.class.getMethod("substring", int.class);
        // 在s对象上调用该方法并获取结果:
        String r = (String) m.invoke(s, 6);
        // 打印调用结果:
        System.out.println(r);


        System.out.println("==================用反射来调用调用静态方法============");
// 获取Integer.parseInt(String)方法，参数为String:

//        调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null
        Method m2 = Integer.class.getMethod("parseInt", String.class);
        // 调用该静态方法并获取结果:
        Integer n = (Integer) m2.invoke(null, "12345");
        // 打印调用结果:
        System.out.println(n);


        System.out.println("==================用反射来调用调用静态方法============");
        Person p = new Person();
        Method m4 = p.getClass().getDeclaredMethod("setName", String.class);

//        可以通过Class.getDeclaredMethod()获取该方法实例，但直接对其调用将得到一个IllegalAccessException。
//        为了调用非public方法，我们通过Method.setAccessible(true)允许其调用：
        m4.setAccessible(true);
        m4.invoke(p, "Bob");
        System.out.println(p.name);


        System.out.println("==================多态============");
        // 获取Person的hello方法:
        Method h = Person.class.getMethod("hello");
        // 对Student实例调用hello方法:
        h.invoke(new Student());

//        使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）。
    }
}
