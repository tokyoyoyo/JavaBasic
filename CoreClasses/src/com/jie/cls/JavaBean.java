package com.jie.cls;

//        若干private实例字段；
//        通过public方法 Get、Set来读写实例字段。boolean字段比较特殊，它的读方法一般命名为isXyz()

//          满足以上规范的类称为，JavaBean

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

//          getter和setter也是一种数据封装的方法。
public class JavaBean {

//    枚举一个JavaBean的所有属性，可以直接使用Java核心库提供的Introspector
    public static void main(String[] args) throws Exception {
        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println(pd.getName());
            System.out.println("  " + pd.getReadMethod());
            System.out.println("  " + pd.getWriteMethod());
        }
    }

    class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
