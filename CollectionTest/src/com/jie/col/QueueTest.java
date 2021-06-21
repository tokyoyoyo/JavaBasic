package com.jie.col;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");

        System.out.println("从队列取出元素:");
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // pear
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()+ " : 因为队列是空的"); // null,


//        按照面向抽象编程的原则编写代码，可以大大提高代码的质量。
        // 这是一个List:
        List<String> list = new LinkedList<>();
            // 这是一个Queue:
        Queue<String> queue = new LinkedList<>();



        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        System.out.println("队首永远都是apple，因为peek()不会删除它");
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
    }
}
