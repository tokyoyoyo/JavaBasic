package com.ProcessControl;

public class whileTest {
    public static void main(String[] args) {
//        int sum = 0; // 累加的和，初始化为0
//        int n = 1;
//        while (n <= 100) { // 循环条件是n <= 100
//            sum = sum + n; // 把n累加到sum中
//            n ++; // n自身加1
//        }
//        System.out.println(sum); // 5050

//先执行循环，再判断条件，条件满足时继续循环，条件不满足时退出。至少会执行一次
        System.out.println("==================do……while===================");
        int sum = 0;
        int m = 20;
        int n = 100;
        // 使用do while计算M+...+N:
        do {
            sum+=m++;
        } while (m <101);
        System.out.println(sum);

    }
}
