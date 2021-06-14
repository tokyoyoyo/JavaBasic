package com.ProcessControl;

import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {
        /*
        %d	格式化输出整数
        %x	格式化输出十六进制整数
        %f	格式化输出浮点数
        %e	格式化输出科学计数法表示的浮点数
        %s	格式化字符串
        * */
        System.out.println("==================换行====================");
        System.out.print("A,");
        System.out.print("B,");
        System.out.print("C.");
        System.out.println();
        System.out.println("END");

        System.out.println("==================格式化输出====================");

        double d = 3.1415926;
        System.out.printf("%.2f\n", d); // 显示两位小数3.14
        System.out.printf("%.4f\n", d); // 显示4位小数3.1416

        int n = 12345000;
        System.out.printf("n=%d, hex=%08X", n, n); // 两个%占位符必须传入两个数
        // %X表示将整数格式化为16进制整数，并且字母变成大写形式

        System.out.println();
        /*
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
        */




        Scanner scanner = new Scanner(System.in);
        System.out.print("请输出上次考试成绩：");
        int Score01 = scanner.nextInt();
        System.out.println();
        System.out.print("请输出这次考试成绩：");
        int Score02 = scanner.nextInt();
        float change = (float) (Score02 - Score01) / (float)Score01;
        System.out.printf("你进步了%.2f%%", change*100);

    }
}
