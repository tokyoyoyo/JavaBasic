package com.ProcessControl;

public class ForTest {
    public static void main(String[] args) {
        //for循环的功能非常强大，使用计数器实现循环。先初始化计数器，在每次循环前检测循环条件，
        // 在每次循环后更新计数器。


        //  使用for循环时，计数器变量i要尽量定义在for循环中：
//        int[] ns = { 1, 4, 9, 16, 25 };
//        int i;
//        for (i=0; i<ns.length; i++) {
//            System.out.println(ns[i]);
//        }
//        // 仍然可以使用i
//        int a = i;

        // 退出for循环后，变量i仍然可以被访问，这就破坏了变量应该把访问范围缩到最小的原则。

        //for each循环

//        for (int n : ns) {
//            System.out.println(n);
//        }


//        圆周率π可以使用公式计算：
        double pi = 0;
        int a =1;
        for (int i =1; i < 10000 ; i+=2) {
            pi += 4*a*1/(double)i;
            a*=-1;
        }

        System.out.println(pi);
    }
}
