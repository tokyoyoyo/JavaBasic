package com.jie.inner;

public class AnonymousClass {
    public static void main(String[] args) {
        Out outer = new Out("Nested");
        outer.asyncHello();


    }
}

class Out {
    private String name;

    private static String NAME = "OUTER";



    Out(String name) {
        this.name = name;
    }



    void asyncHello() {
        Runnable r = new Runnable() {
            // 实现必要的抽象方法...


            //            Runnable本身是接口，接口是不能实例化的，所以这里实际上是定义了一个实现了Runnable接口的匿名类，
            //            并且通过new实例化该匿名类，然后转型为Runnable
            @Override
            public void run() {
                System.out.println("Hello, " + Out.this.name);
            }
        };
        new Thread(r).start();
    }
}