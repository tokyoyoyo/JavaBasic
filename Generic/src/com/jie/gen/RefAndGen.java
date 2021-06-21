package com.jie.gen;

//Java的部分反射API也是泛型。

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RefAndGen {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

//        Class<T>是泛型
        // compile warning:
        Class clazz = String.class;
        String str = (String) clazz.newInstance();
        // no warning:
        Class<String> clazz2 = String.class;
        String str2 = clazz2.newInstance();


        //调用Class的getSuperclass()方法返回的Class类型是Class<? super T>：
        Class<? super String> sup = String.class.getSuperclass();

//        构造方法Constructor<T>也是泛型：

        Class<Integer> clazz3 = Integer.class;
        Constructor<Integer> cons = clazz3.getConstructor(int.class);
        Integer i = cons.newInstance(123);

//        我们可以声明带泛型的数组，但不能用new操作符创建带泛型的数组：
        Pair<String>[] ps = null; // ok
//        Pair<String>[] ps = new Pair<String>[2]; // compile error!


//        必须通过强制转型实现带泛型的数组：
        @SuppressWarnings("unchecked")
        Pair<String>[] ps2 = (Pair<String>[]) new Pair[2];


//        操作arr可能导致从ps获取元素时报错，
//        Pair[] arr = new Pair[2];
//        Pair<String>[] ps = (Pair<String>[]) arr;
//
//        ps[0] = new Pair<String>("a", "b");
//        arr[1] = new Pair<Integer>(1, 2);
//// ClassCastException:
//        Pair<String> p = ps[1];
//        String s = p.getFirst();


//        要安全地使用泛型数组，必须扔掉arr的引用：
        @SuppressWarnings("unchecked")
        Pair<String>[] ps4 = (Pair<String>[]) new Pair[2];


//        带泛型的数组实际上是编译器的类型擦除：
        Pair[] arr = new Pair[2];
        Pair<String>[] ps3 = (Pair<String>[]) arr;

        System.out.println(ps3.getClass() == Pair[].class); // true

        String s1 = (String) arr[0].getFirst();
        String s2 = ps[0].getFirst();

    }
/*
            不能直接创建泛型数组T[]，因为擦拭后代码变为Object[]
                // compile error:
                public class Abc<T> {
                    T[] createArray() {
                        return new T[5];
                    }
                }

//        必须借助Class<T>来创建泛型数组：
                T[] createArray(Class<T> cls) {
                    return (T[]) Array.newInstance(cls, 5);
                }


        我们还可以利用可变参数创建泛型数组T[]：

                public class ArrayHelper {  似乎可以安全地创建一个泛型数组。但实际上，这种方法非常危险。
                    @SafeVarargs
                    static <T> T[] asArray(T... objs) {
                        return objs;
                    }
                }

                String[] ss = ArrayHelper.asArray("a", "b", "c");
                Integer[] ns = ArrayHelper.asArray(1, 2, 3);



        因为擦拭法，在pickTwo()方法内部，编译器无法检测K[]的正确类型，因此返回了Object[]。
            public static void main(String[] args) {
                String[] arr = asArray("one", "two", "three");
                System.out.println(Arrays.toString(arr));
                // ClassCastException:
                String[] firstTwo = pickTwo("one", "two", "three");
                System.out.println(Arrays.toString(firstTwo));
            }

            static <K> K[] pickTwo(K k1, K k2, K k3) {
                return asArray(k1, k2);
            }

            static <T> T[] asArray(T... objs) {
                return objs;
            }

 */

}

/*
        部分反射API是泛型，例如：Class<T>，Constructor<T>；

        可以声明带泛型的数组，但不能直接创建带泛型的数组，必须强制转型；

        可以通过Array.newInstance(Class<T>, int)创建T[]数组，需要强制转型；

        同时使用泛型和可变参数时需要特别小心。

 */