package com.jie.obj;

public class ConstructionMethod {
    public static void main(String[] args) {
        Person p = new Person("Xiao Ming", 15);
        System.out.println(p.getName());
        System.out.println(p.getAge());
    }
}

class Person {
    private String name;
    private int age;
    //构造方法的名称就是类名。构造方法的参数没有限制，在方法内部，也可以编写任意语句。
    // 和普通方法相比，构造方法没有返回值（也没有void），调用构造方法，必须用new操作符。


    public Person() {//默认构造方法
        //果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法
        //如果既要能使用带参数的构造方法，又想保留不带参数的构造方法，那么只能把两个构造方法都定义出来：
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void run() {
        System.out.println("Person.run");
    }
}

//既对字段进行初始化，又在构造方法中对字段进行初始化
//构造方法的代码由于后运行，所以，初始化字段值最终由构造方法的代码覆盖

//可以定义多个构造方法，在通过new操作符调用的时候，编译器通过构造方法的参数数量、位置和类型自动区分

//一个构造方法可以调用其他构造方法，这样做的目的是便于代码复用。调用其他构造方法的语法是this(…)：
