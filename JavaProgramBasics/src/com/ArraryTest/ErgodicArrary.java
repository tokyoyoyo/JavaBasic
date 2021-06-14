package com.ArraryTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ErgodicArrary {
    public static void main(String[] args) {
        Integer[] ns = { 1, 4, 9, 16, 25 };

        //两种遍历数组的方法
        for (int i=0; i<ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }

        for (int n : ns) {
            System.out.println(n);
        }

        System.out.println(ns); // 直接打印数组变量，得到的是数组在JVM中的引用地址：类似 [I@7852e922

        for (int n : ns) {
            System.out.print(n + ", ");
        }

        System.out.println();
        //Java标准库提供了Arrays.toString()，可以快速打印数组内容：
        System.out.println(Arrays.toString(ns));

        Arrays.sort(ns,Collections.reverseOrder());
        //一定要是包装类才能用Sort逆序排列
        System.out.println(Arrays.toString(ns));


        // 用二维数组表示的学生成绩:
        int[][] scores = {
                { 82, 90, 91 },
                { 68, 72, 64 },
                { 95, 91, 89 },
                { 67, 52, 60 },
                { 79, 81, 85 },
        };
        // TODO:
        double average = 0;
        for (int i = 0 ; i < 5; i++){
            for (int j = 0; j < 3; j++) {
                average += scores[i][j];
            }
        }
        average/=15;
        System.out.println(average);

        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }

    }
}
