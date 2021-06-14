package com.ProcessControl;

import java.util.Scanner;

public class IfTest {
    public static void main(String[] args) {
        int n = 70;
        if (n >= 90) {      //嵌套时应该按照判断范围从大到小进行判断
            System.out.println("优秀");
        } else if (n >= 60) {   //可以else if嵌套串联
            System.out.println("及格了");
        } else {
            System.out.println("挂科了");
        }
        System.out.println("END");

        //花括号在只有一行的时候可以省略，可以，但没必要

        double x = 1 - 9.0 / 10;        //浮点数比较时要利用差值小于某个临界值来判断
        //浮点数的表示往往是个不完全准确的近似值。但0.5就是精准的
        if (Math.abs(x - 0.1) < 0.00001) {
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }

        float a =(float)1/2;
        if ( a == 0.5) {
            System.out.println("a is 0.5");
        } else {
            System.out.println("a is NOT 0.5");
        }

        System.out.println("=======================引用类型的判断===========================");
        //它们的内容是相同的，但是，分别指向不同的对象，用==判断，结果为false
        //要判断引用类型的变量内容是否相等，必须使用equals()方法：
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }

        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }

//        System.out.println("如果变量s1为null，会报NullPointerException：");
//        s1 = null;
//        if (s1.equals("hello")) {
//            System.out.println("hello");
//        }


        System.out.println("要避免NullPointerException错误，可以利用短路运算符&&：");
        if (s1 != null && s1.equals("hello")) {
            System.out.println("hello");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.printf("请输入您的体重(Kg):");
        float BodyWeight = scanner.nextFloat();
        System.out.printf("请输入您的身高（m）:");
        float Height = scanner.nextFloat();

        float BMI = BodyWeight/(Height*Height);

        if(BMI >32){
            System.out.println("非常肥胖");
        }else if(BMI>28 && BMI <=32){
            System.out.println("肥胖");
        }else if (BMI>25 && BMI <=28){
            System.out.println("过重");
        }else if (BMI>18.5 && BMI <=25){
            System.out.println("正常");
        }else{
            System.out.println("过轻");
        }

    }
}
