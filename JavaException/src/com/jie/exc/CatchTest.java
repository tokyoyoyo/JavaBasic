package com.jie.exc;

public class CatchTest {
//    Java中，凡是可能抛出异常的语句，都可以用try ... catch捕获。
//    把可能发生异常的语句放在try { ... }中，然后使用catch捕获对应的Exception及其子类

//    可以使用多个catch语句，每个catch分别捕获对应的Exception及其子类。
//    JVM在捕获到异常后，会从上到下匹配catch语句，匹配到某个catch后，执行catch代码块，然后不再继续匹配
//    多个catch语句只有一个能被执行


    public static void main(String[] args) {


//        try {
//            process1();
//            process2();
//            process3();
//            System.out.println("Test");
//        } catch (
//                IOException e) {
//            System.out.println("IO error");
//        } catch (//    存在多个catch的时候，catch的顺序非常重要：子类必须写在前面，范围先小后大
//                UnsupportedEncodingException e) { // 永远捕获不到
//            System.out.println("Bad encoding");
//        }

//        finally语句
//        无论是否有异常发生，如果都希望执行一些语句，例如清理工作可以用final语句
//        finally语句不是必须的，可写可不写；
//        finally总是最后执行。

//        try {
//            process1();
//            process2();
//            process3();
//
//        } catch (UnsupportedEncodingException e) {
//            System.out.println("Bad encoding");
//        } catch (IOException e) {
//            System.out.println("IO error");
//        } finally {
//            System.out.println("END");
//        }


//        捕获多种异常
//        try {
//            process1();
//            process2();
//            process3();
//        } catch (IOException | NumberFormatException e) { // IOException或NumberFormatException
//            System.out.println("Bad input");
//        } catch (Exception e) {
//            System.out.println("Unknown error");
//        }



    }


}
