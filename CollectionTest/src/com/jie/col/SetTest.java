package com.jie.col;

import java.util.*;

public class SetTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true
        System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
        System.out.println(set.contains("xyz")); // true，元素存在
        System.out.println(set.contains("XYZ")); // false，元素不存在
        System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
        System.out.println(set.size()); // 2，一共两个元素

        System.out.println("====================");

        set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("pear");
        set.add("orange");
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("====================");

        set = new TreeSet<>();
        set.add("apple");
        set.add("banana");
        set.add("pear");
        set.add("orange");
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("====================");


        List<Message> received = new ArrayList<>();

        received.add(new Message(1, "Hello!"));
        received.add(new Message(3, "去哪吃饭？"));
        received.add(new Message(2, "发工资了吗？"));
        received.add( new Message(2, "发工资了吗？"));
        received.add(new Message(3, "去哪吃饭？"));

        received.add(new Message(4, "Bye"));
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.print(message.sequence);
            System.out.println(message.text);
        }




    }

    static List<Message> process(List<Message> received) {

        Set<Message> mes = new TreeSet<>(received);
        return new ArrayList<Message>(mes);
    }


    /*
            Set实际上相当于只存储key、不存储value的Map。我们经常用Set用于去除重复元素。

            因为放入Set的元素和Map的key类似，都要正确实现equals()和hashCode()方法，否则该元素无法正确地放入Set。

            最常用的Set实现类是HashSet，实际上，HashSet仅仅是对HashMap的一个简单封装，






            Set接口并不保证有序，而SortedSet接口则保证元素是有序的：

                    HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
                    TreeSet是有序的，因为它实现了SortedSet接口。
     */


}


class Message implements Comparable{    //实现Comparable接口，就可以直接放进TreeSet进行去重了
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Message) {
            Message m = (Message) o;
            return this.sequence == m.sequence && Objects.equals(this.text, m.text);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int n = 0;
        n = 31 * n + this.sequence;
        n = 31 * n + this.text.hashCode();
        return n;
    }


    @Override
    public int compareTo(Object o) {
        Message m = (Message) o;
        if (this.sequence==m.sequence) {
            return 0;
        }
        return this.sequence>m.sequence? 1: -1;
    }
}