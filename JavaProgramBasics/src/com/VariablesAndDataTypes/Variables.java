package com.VariablesAndDataTypes;

public class Variables {

    public static void main(String[] args) {
        System.out.println("====================int,整形变量==================");
        int n = 100; // 定义变量n，同时赋值为100
        System.out.println("n = " + n); // 打印n的值

        n = 200; // 变量n赋值为200
        System.out.println("n(第二次赋值) = " + n); // 打印n的值

        int x = n; // 变量x赋值为n（n的值为200，因此赋值后x的值也是200）
        System.out.println("x（n赋值给x） = " + x); // 打印x的值

        x = x + 100; // 变量x赋值为x+100（x的值为200，因此赋值后x的值是200+100=300）
        System.out.println("x（x = x + 100） = " + x); // 打印x的值
        System.out.println("n（n=？） = " + n);

        System.out.println("====================float,浮点数变量==================");

        float a = 3.14f; // 定义变量a，同时赋值为3.14，对于float类型，需要加上f后缀。
        System.out.println("a = " + a); // 打印a的值

        a = 3.14e38f; // 变量a赋值为3.14e38f
        System.out.println("a(第二次赋值) = " + a); // 打印a的值

        float b = 3.14e38f; // 变量b赋值为a
        System.out.println("b（a赋值给b） = " + b); // 打印b的值

        b = 4.9e4f; // 变量b赋值为4.9e4f
        System.out.println("b（b = 4.9e4f） = " + b); // 打印b的值
        System.out.println("a（a=？） = " + a);

    }

}
