package com.jie.col;

import java.util.Deque;
import java.util.LinkedList;

public class DequeueTest {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A
        deque.offerLast("B"); // A <- B
        deque.offerFirst("C"); // C <- A <- B
        System.out.println(deque.pollFirst()); // C, 剩下A <- B
        System.out.println(deque.pollLast()); // B, 剩下A
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null

//        尽量持有接口，而不是具体的实现类
        // 不推荐的写法:
        LinkedList<String> d1 = new LinkedList<>();
        d1.offerLast("z");
        // 推荐的写法：
        Deque<String> d2 = new LinkedList<>();
        d2.offerLast("z");
    }
}
