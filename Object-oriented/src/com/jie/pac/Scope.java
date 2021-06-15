package com.jie.pac;

public class Scope {
    /*
    如果不确定是否需要public，就不声明为public，即尽可能少地暴露对外的字段和方法。

    把方法定义为package权限有助于测试，因为测试类和被测试类只要位于同一个package，测试代码就可以访问被测试类的package权限方法。

    一个.java文件只能包含一个public类，但可以包含多个非public类。如果有public类，文件名必须和public类的名字相同。*/
    void hi(String name) { // ①
        String s = name.toLowerCase(); // ②
        int len = s.length(); // ③
        if (len < 10) { // ④
            int p = 10 - len; // ⑤
            for (int i=0; i<10; i++) { // ⑥
                System.out.println(); // ⑦
            } // ⑧
        } // ⑨
    } // ⑩

//    方法参数name是局部变量，它的作用域是整个方法，即①～⑩；
//    变量s的作用域是定义处到方法结束，即②～⑩；
//    变量len的作用域是定义处到方法结束，即③～⑩；
//    变量p的作用域是定义处到if块结束，即⑤～⑨；
//    变量i的作用域是for循环，即⑥～⑧。
//    使用局部变量时，应该尽可能把局部变量的作用域缩小，尽可能延后声明局部变量。

    private void hi() {
    }
    public static void main(String[] args) {
        Inner i = new Inner();
        i.hi();
         //        一个类内部还定义了嵌套类，那么，嵌套类拥有访问private的权限：
    }

    // private方法:
    private static void hello() {
        System.out.println("private hello!");
    }

    // 静态内部类:
    static class Inner {
        public void hi() {
            Scope.hello();
        }
    }
/*
    final

    final与访问权限不冲突，它有很多作用。
        用final修饰class可以阻止被继承：
        用final修饰method可以阻止被子类覆写：
        用final修饰field可以阻止被重新赋值：
        用final修饰局部变量可以阻止被重新赋值：
 */
}
