package com.jie.obj;

import java.util.Arrays;

//实例字段在每个实例中都有自己的一个独立“空间”，但是静态字段只有一个共享“空间”，所有实例都会共享该字段。
public class StaticField {
    public static void main(String[] args) {
        PersonS ming = new PersonS("Xiao Ming", 12);
        PersonS hong = new PersonS("Xiao Hong", 15);
        ming.number = 88;
        System.out.println(hong.number);
        hong.number = 99;
        System.out.println(ming.number);
//        对于静态字段，无论修改哪个实例的静态字段，效果都是一样的：
//        所有实例的静态字段都被修改了，原因是静态字段并不属于实例

//        实例可以访问静态字段，但是它们指向的其实都是Person class的静态字段。所以，所有实例共享一个静态字段

        PersonS.setNumber(99);
        System.out.println(PersonS.number);
//        调用实例方法必须通过一个实例变量，而调用静态方法则不需要实例变量，通过类名就可以调用。静态方法类似其它编程语言的函数
//        静态方法属于class而不属于实例，因此，静态方法内部，无法访问this变量，也无法访问实例字段，它只能访问静态字段
//        通过实例变量也可以调用静态方法，但这只是编译器自动帮我们把实例改写成类名

//        静态方法经常用于工具类。例如：
//        Arrays.sort()
//        Math.random()
//        静态方法也经常用于辅助方法。注意到Java程序的入口main()也是静态方法。
    }
}

class PersonS {
    public String name;
    public int age;

    public static int number;

    public static void setNumber(int value) {
        number = value;
    }

    public PersonS(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
