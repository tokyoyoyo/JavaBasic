package com.jie;

//伪代码，只是记录使用逻辑
public class ThreadLocalTest {


    static ThreadLocal<User> threadLocalUser = new ThreadLocal<>();

    public static void main(String[] args) {

        log("start main...");

//        Thread对象代表一个线程，我们可以在代码中调用Thread.currentThread()获取当前线程。例如，打印日志时，可以同时打印出当前线程的名

        new Thread(() -> {
            log("run task...");
        }).start();
        new Thread(() -> {
            log("print...");
        }).start();
        log("end main.");

    }

    void step1() {
        User u = threadLocalUser.get();
        log();
       // printUser();
    }

    void log() {
        User u = threadLocalUser.get();
       // println(u.name);
    }

    void step2() {
        User u = threadLocalUser.get();
        //checkUser(u.id);
    }



    static void log(String s) {
        System.out.println(Thread.currentThread().getName() + "            : " + s);
    }

    void processUser(User user) {
        try {
            threadLocalUser.set(user);


//            "step1();"
//            "step2();"


        } finally {
            threadLocalUser.remove();
        }
    }

}

class User {
    private String name;
    private String pwd;

}