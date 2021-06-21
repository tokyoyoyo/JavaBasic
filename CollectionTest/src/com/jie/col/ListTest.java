package com.jie.col;

import java.util.ArrayList;
import java.util.List;

//List接口允许我们添加重复的元素，即List内部的元素可以重复
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple"); // size=1
        list.add("pear"); // size=2
        list.add("apple"); // 允许重复添加元素，size=3
        System.out.println(list.size());


        list.add(null); // size=4   List还允许添加null：
        String four = list.get(3); // null
        System.out.println(four);

        for (String s : list) {
            System.out.printf(s+ "  ");
        }


        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list2.add(i);
        }

        Integer[] array = list2.toArray(new Integer[list2.size()]);




    }

}


/*
        在末尾添加一个元素：boolean add(E e)
        在指定索引添加一个元素：boolean add(int index, E e)
        删除指定索引的元素：E remove(int index)
        删除某个元素：boolean remove(Object e)
        获取指定索引的元素：E get(int index)
        获取链表大小（包含元素的个数）：int size()


        总是优先使用ArrayList


 */