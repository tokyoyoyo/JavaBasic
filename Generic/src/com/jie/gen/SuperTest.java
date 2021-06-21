package com.jie.gen;

import java.util.List;

public class SuperTest {

    public static void main(String[] args) {

//        <?>通配符有一个独特的特点，就是：PairSuper<?>是所有PairSuper<T>的超类
        PairSuper<Integer> p = new PairSuper<>(123, 456);
        PairSuper<?> p2 = p; // 安全地向上转型
        System.out.println(p2.getFirst() + ", " + p2.getLast());

    }


    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i=0; i<src.size(); i++) {
            T t = src.get(i);
            dest.add(t);
        }
    }
    /*
            把一个List的每个元素依次添加到另一个List中。它的第一个参数是List<? super T>，
            表示目标List，第二个参数List<? extends T>，表示要复制的List。我们可以简单地用for循环实现复制。
            在for循环中，我们可以看到，对于类型<? extends T>的变量src，我们可以安全地获取类型T的引用，
            而对于类型<? super T>的变量dest，我们可以安全地传入T的引用。

                copy()方法内部不会读取dest，因为不能调用dest.get()来获取T的引用；
                copy()方法内部也不会修改src，因为不能调用src.add(T)。

                可以安全地把一个List<Integer>添加到List<Number>，但是无法反过来添加：

    */


}


class PairSuper<T> {
    private T first;
    private T last;

    public PairSuper(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }       //      getFirst()方法，它的方法签名实际上是：? super Integer getFirst();
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }       //    它的方法签名实际上是：void setFirst(? super Integer);


    public void setLast(T last) {
        this.last = last;
    }
}

/*
        我们无法使用Integer类型来接收getFirst()的返回值，即下面的语句将无法通过编译：
        Integer x = p.getFirst();

        如果传入的实际类型是Pair<Number>，编译器无法将Number类型转型为Integer。
            注意：虽然Number是一个抽象类，我们无法直接实例化它。但是，即便Number不是抽象类，
            这里仍然无法通过编译。此外，传入Pair<Object>类型时，编译器也无法将Object类型转型为Integer。
            唯一可以接收getFirst()方法返回值的是Object类型：

        使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只能写，不能读。
                因为不确定读到的东西会被什么接受，处理object可以接受一切class

        PECS原则
                需要返回T的src是生产者，因此声明为List<? extends T>，
                需要写入T的dest是消费者，因此声明为List<? super T>

        无限定通配符
                Java的泛型还允许使用无限定通配符（Unbounded Wildcard Type），即只定义一个?：

                <?>通配符既没有extends，也没有super，因此：只能做一些null判断：
                        不允许调用set(T)方法并传入引用（null除外）；
                        不允许调用T get()方法并获取T引用（只能获取Object引用）。

        使用类似<? super Integer>通配符作为方法参数时表示：
            方法内部可以调用传入Integer引用的方法，例如：obj.setFirst(Integer n);；
            方法内部无法调用获取Integer引用的方法（Object除外），例如：Integer n = obj.getFirst();。
            即使用super通配符表示只能写不能读。
        使用extends和super通配符要遵循PECS原则。
            无限定通配符<?>很少使用，可以用<T>替换，同时它是所有<T>类型的超类。

*/