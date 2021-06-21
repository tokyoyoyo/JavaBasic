package com.jie.gen;

public class DiyGen {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Pair2<String, Integer> p = new Pair2<>("test", 123);

        Pair3<String> pair = new Pair3<>(String.class);
    }
}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }


//    静态方法
    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}



//泛型还可以定义多种类型。例如，我们希望Pair不总是存储两个类型一样的对象，就可以使用类型<T, K>

class Pair2<T, K> {
    private T first;
    private K last;
    public Pair2(T first, K last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }

    public K getLast() {
        return last;
    }
}

class Pair3<T> {
    private T first;
    private T last;
    public Pair3(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        first = clazz.newInstance();
        last = clazz.newInstance();
    }
}

/*
        Java语言的泛型实现方式是擦拭法（Type Erasure）。
        擦拭法是指，虚拟机对泛型其实一无所知，所有的工作都是编译器做的。
            编译器把类型<T>视为Object；
            编译器根据<T>实现安全的强制转型。
        虚拟机执行的代码是经过强制转型的代码，因此泛型对虚拟机来说是透明的

        Java泛型的局限：
            局限一：<T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型
                        Pair<int> p = new Pair<>(1, 2); // compile error!
            局限二：无法取得带泛型的Class。观察以下代码：
                        T是Object，我们对不同的泛型实例获取Class时，获取到的是同一个Class，
                        无论T的类型是什么，getClass()返回同一个Class实例，因为编译后它们全部都是Pair<Object>。
            局限三：无法判断带泛型的类型：
                        原因同上
            局限四：不能实例化T类型：
                        要实例化T类型，我们必须借助额外的Class<T>参数：
                                public class Pair<T> {
                                    private T first;
                                    private T last;
                                    public Pair(Class<T> clazz) {
                                        first = clazz.newInstance();
                                        last = clazz.newInstance();
                                    }
                                }
                                上述代码借助Class<T>参数并通过反射来实例化T类型，使用的时候，也必须传入Class<T>。例如：
                                 Pair<String> pair = new Pair<>(String.class);


        泛型继承

                一个类可以继承自一个泛型类。例如：父类的类型是Pair<Integer>，子类的类型是IntPair，可以这么继承
                public class IntPair extends Pair<Integer> {
                }
                使用的时候，因为子类IntPair并没有泛型类型，所以，正常使用即可：
                IntPair ip = new IntPair(1, 2);

                    给定一个变量Pair<Integer> p，无法从p中获取到Integer类型。

                    但是，在父类是泛型类型的情况下，编译器就必须把类型T（对IntPair来说，也就是Integer类型）
                    保存到子类的class文件中，不然编译器就不知道IntPair只能存取Integer这种类型。

                    在继承了泛型类型的情况下，子类可以获取父类的泛型类型



        泛型方法要防止重复定义方法，例如：public boolean equals(T obj)；


*/