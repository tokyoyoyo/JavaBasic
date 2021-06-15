package com.jie.cls;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class CommonTools {
    public static void main(String[] args) {


//        Math类就是用来进行数学计算的，它提供了大量的静态方法来便于我们实现数学计算

        System.out.println("Math类就是用来进行数学计算的，它提供了大量的静态方法来便于我们实现数学计算");
//        求绝对值：
        System.out.println("================求绝对值=====================");
        System.out.println(      "Math.abs(-100)   = "+Math.abs(-100)    );
        System.out.println(      "Math.abs(-7.8)   =  " +   Math.abs(-7.8)   );
        System.out.println();

//        取最大或最小值：
        System.out.println("================取最大或最小值=====================");
        System.out.println(   "Math.max(100, 99)     =  "  + Math.max(100, 99)          );
        System.out.println(   "Math.min(1.2, 2.3)     =  "  + Math.min(1.2, 2.3)         );
        System.out.println();

//        计算xy次方：
        System.out.println("================计算xy次方=====================");
        System.out.println(    "Math.pow(2, 10)    =  "   + Math.pow(2, 10)     );
        System.out.println();

//        计算√x：
        System.out.println("===============计算√x=====================");
        System.out.println(    "Math.sqrt(2)     =  " +     Math.sqrt(2)    );
        System.out.println();

//        计算以e为底的对数：
        System.out.println("================计算以e为底的对数=====================");
        System.out.println(    "Math.log(4)    =  "  +  Math.log(4)    );// 1.386...
        System.out.println();

//        计算以10为底的对数：
        System.out.println("================计算以10为底的对数=====================");
        System.out.println(     "Math.log10(100)   =  "   +  Math.log10(100)    );// 2
        System.out.println();

//        三角函数：
        System.out.println("================三角函数=====================");
        System.out.println(    "Math.sin(3.14)    =  " +    Math.sin(3.14)   );// 0.00159...
        System.out.println(    "Math.cos(3.14)    =  " +    Math.cos(3.14)   );// -0.9999...
        System.out.println(    "Math.tan(3.14)    =  " +    Math.tan(3.14)   );// -0.0015...
        System.out.println(     "Math.asin(1.0)   =  " +    Math.asin(1.0)   );// 1.57079...
        System.out.println(     "Math.acos(1.0)   =  " +    Math.acos(1.0)   ); // 0.0
        System.out.println();

//        Math提供了几个数学常量：
        System.out.println("===============Math提供了几个数学常量=====================");
        double pi = Math.PI; // 3.14159...
        double e = Math.E; // 2.7182818...
        System.out.println(       "sin(π/6) = 0.5   =  "+Math.sin(Math.PI / 6));
        System.out.println();

//        生成一个随机数x，x的范围是0 <= x < 1：
        System.out.println("================生成一个随机数x，x的范围是0 <= x < 1====================");
        System.out.println(                Math.random()          ); // 0.53907... 每次都不一样
        System.out.println();

//        有一定范围的随机数
        System.out.println("================有一定范围的随机数=====================");
        double x = Math.random(); // x的范围是[0,1)
        double min = 10;
        double max = 50;
        double y = x * (max - min) + min; // y的范围是[10,50)
        long n = (long) y; // n的范围是[10,50)的整数
        System.out.println(y);
        System.out.println(n);

//        Random用来创建伪随机数。所谓伪随机数，是指只要给定一个初始的种子，产生的随机数序列是完全一样的

        System.out.println("Random用来创建伪随机数。所谓伪随机数，是指只要给定一个初始的种子，产生的随机数序列是完全一样的");
        System.out.println();

        System.out.println("============使用nextInt()、nextLong()、nextFloat()、nextDouble()来生成一个随机数=========");
        Random r = new Random();

        System.out.println(       "r.nextInt()   =  "+r.nextInt());// 2071575453,每次都不一样
        System.out.println(       "r.nextInt(10)   =  "+r.nextInt(10));// 5,生成一个[0,10)之间的int
        System.out.println(       "r.nextLong()   =  "+r.nextLong());// 8811649292570369305,每次都不一样
        System.out.println(       "r.nextFloat()   =  "+r.nextFloat());// 0.54335...生成一个[0,1)之间的float
        System.out.println(       "r.nextDouble()   =  "+r.nextDouble());// 0.3716...生成一个[0,1)之间的double
        System.out.println();

        System.out.println("==========Random实例时指定一个种子，就会得到完全确定的随机数序列=====");
        Random ro = new Random(12345);
        for (int i = 0; i < 10; i++) {
            System.out.println(ro.nextInt(100));
        }// 51, 80, 41, 28, 55...
        System.out.println();

        System.out.println("==========SecureRandom是用来创建一个不可预测的安全的随机数=====");
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt(100));
        System.out.println();


        System.out.println("==========可以优先获取高强度的安全随机数生成器，如果没有提供，再使用普通等级的安全随机数生成器=====");

        SecureRandom sr2 = null;
        try {
            sr2 = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException ee) {
            sr2 = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr2.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));

    }

}
