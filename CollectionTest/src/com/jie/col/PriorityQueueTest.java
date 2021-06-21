package com.jie.col;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        Queue<String> q = new PriorityQueue<>();

        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // null,因为队列为空


//        放入PriorityQueue的元素，必须实现Comparable接口，PriorityQueue会根据元素的排序顺序决定出队的优先级。


        System.out.println("========================");

        Queue<User> q2 = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q2.offer(new User("Bob", "A12"));
        q2.offer(new User("Alice", "A2"));
        q2.offer(new User("Boss", "V1"));
        System.out.println(q2.poll()); // Boss/V1
        System.out.println(q2.poll()); // Bob/A1
        System.out.println(q2.poll()); // Alice/A2
        System.out.println(q2.poll()); // null,因为队列为空
    }
}



class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}


class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:

            int v1 = u1.number.length();
            int v2 = u2.number.length();
            String n1 = u1.number.substring(1, v1);
            String n2 = u2.number.substring(1, v2);
            // 负值，n1排前面
            return Integer.parseInt(n1) - Integer.parseInt(n2);
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}