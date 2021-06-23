package com.jie.thread;

public class StopThread3 {
    public static void main(String[] args) throws InterruptedException {

        HelloThread3 t = new HelloThread3();
        t.start();
        Thread.sleep(1);
        t.running = false; // 标志位置为false

    }
}


class HelloThread3 extends Thread {
    public volatile boolean running = true;     //独有的变量
//                      标志位boolean running是一个线程间共享的变量。线程间共享变量需要使用volatile关键字标记，
//                      确保每个线程都能读取到更新后的变量值。
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}