package com.jie.col;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {


        System.out.println("排序==============");
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("orange");
        // 排序前:
        System.out.println(list);
        Collections.sort(list);
        // 排序后:
        System.out.println(list);

        System.out.println("洗牌===============");
        List<Integer> list2 = new ArrayList<>();
        for (int i=0; i<10; i++) {
            list2.add(i);
        }
        // 洗牌前:
        System.out.println(list2);
        Collections.shuffle(list2);
        // 洗牌后:
        System.out.println(list);

        System.out.println("===========================");

        System.out.println("这种封装实际上是通过创建一个代理对象，拦截掉所有修改方法实现的");
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        mutable.add("orange");
        System.out.println(immutable);

        mutable = null;//丢掉原引用

        List<String> mutable2 = immutable;

        //mutable2.add("test");         //丢掉原引用就不能再修改了
        System.out.println("Test==================");
        System.out.println(mutable2);
    }
}
