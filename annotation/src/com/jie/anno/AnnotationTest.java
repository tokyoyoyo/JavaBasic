package com.jie.anno;

public class AnnotationTest {

    public static void main(String[] args) {


    }
}


/*
Java的注解可以分为三类：

        第一类是由编译器使用的注解，例如：

                @Override：让编译器检查该方法是否正确地实现了覆写；
                @SuppressWarnings：告诉编译器忽略此处代码产生的警告。
                这类注解不会被编译进入.class文件，它们在编译后就被编译器扔掉了。

        第二类是由工具处理.class文件使用的注解，比如有些工具会在加载class的时候，对class做动态修改，
        实现一些特殊的功能。这类注解会被编译进入.class文件，但加载结束后并不会存在于内存中。
        这类注解只被一些底层库使用，一般我们不必自己处理。

        第三类是在程序运行期能够读取的注解，它们在加载后一直存在于JVM中，
        这也是最常用的注解。例如，一个配置了@PostConstruct的方法会在调用构造方法后自动被调用
        （这是Java代码读取该注解实现的功能，JVM并不会识别该注解）。


        定义一个注解时，还可以定义配置参数。配置参数可以包括：

            所有基本类型；
            String；
            枚举类型；
            基本类型、String、Class以及枚举的数组


        因为配置参数必须是常量，所以，上述限制保证了注解在定义时就已经确定了每个参数的值。

*/