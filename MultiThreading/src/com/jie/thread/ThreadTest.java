package com.jie.thread;

public class ThreadTest {
    public static void main(String[] args) {

        Thread myThread = new MyThread0();
        myThread.start();
//        从Thread派生一个自定义类，然后覆写run()方法

        System.out.println("main   begin");
        Thread thread = new Thread (() -> {
            try {

                run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
                //创建Thread实例时，传入一个Runnable实例：
        thread.setPriority(3);      //1~10, 默认值5
            //优先级高的线程被操作系统调度的优先级较高，操作系统对高优先级线程可能调度更频繁，
             // 但我们决不能通过设置优先级来确保高优先级的线程一定会先执行。
        thread.start();


        System.out.println("main end");



    }

    private static void run() throws InterruptedException {


        System.out.println("thread begin");
        System.out.println("thread end");

        Thread.sleep(200);

    }
}



class MyThread0 extends Thread {
    @Override
    public void run() {

        System.out.println("start new thread!");
    }

}