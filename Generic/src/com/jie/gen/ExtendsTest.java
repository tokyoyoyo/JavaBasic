package com.jie.gen;

public class ExtendsTest {

//    List<? extends Integer> 的限制：可读不可写
//
//          允许调用get()方法获取Integer的引用；
//          不允许调用set(? extends Integer)方法并传入任何Integer的引用（null除外）



    public static void main(String[] args) {

        int sum = ExtendsTest.add(new Pair<Number>(1, 2));

        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);


        Pair<Integer> p2 = new Pair<>(123, 456);
        int n2 = add2(p2);
        System.out.println(n);

    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    //        使用Pair<? extends Number>使得方法接收所有泛型类型为Number或Number子类的Pair类型

    static int add2(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        //p.setFirst(new Integer(first.intValue() + 100));
        //p.setLast(new Integer(last.intValue() + 100));
        return p.getFirst().intValue() + p.getFirst().intValue();

        /*
                编译错误:
                        编译错误发生在p.setFirst()传入的参数是Integer类型

                        原因还在于擦拭法。如果我们传入的p是Pair<Double>，显然它满足参数定义Pair<? extends Number>，
                        然而，Pair<Double>的setFirst()显然无法接受Integer类型。

                        <? extends Number>通配符的一个重要限制：方法参数签名setFirst(? extends Number)
                        无法传递任何Number的子类型给setFirst(? extends Number)。

                        唯一的例外是可以给方法参数传入null：

                        p.setFirst(null); // ok, 但是后面会抛出NullPointerException
                        p.getFirst().intValue(); // NullPointerException

        */
    }


    static int addN(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

}

/*
        <? extends Number>的泛型定义称之为上界通配符（Upper Bounds Wildcards），即把泛型类型T的上界限定在Number

        如果我们考察对Pair<? extends Number>类型调用getFirst()方法，实际的方法签名变成了：

            <? extends Number> getFirst();      返回值是Number或Number的子类，因此，可以安全赋值给Number类型的变量：

            Number x = p.getFirst();            我们不可预测实际类型就是Integer，

            Integer x = p.getFirst();           这是因为实际的返回类型可能是Integer，也可能是Double或者其他类型，
                                                编译器只能确定类型一定是Number的子类（包括Number类型本身），但具体类型无法确定。


        方法参数类型List<? extends Integer>表明了该方法内部只会读取List的元素，不会修改List的元素
        （因为无法调用add(? extends Integer)、remove(? extends Integer)这些方法。
        换句话说，这是一个对参数List<? extends Integer>进行只读的方法（恶意调用set(null)除外）


        使用类似<? extends Number>通配符作为方法参数时表示：
            方法内部可以调用获取Number引用的方法，例如：Number n = obj.getFirst();；
            方法内部无法调用传入Number引用的方法（null除外），例如：obj.setFirst(Number n);。
            即一句话总结：使用extends通配符表示可以读，不能写。

        使用类似<T extends Number>定义泛型类时表示：
            泛型类型限定为Number以及Number的子类。

*/