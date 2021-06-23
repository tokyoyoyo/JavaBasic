package com.jie.sync;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConCurrentCollection {
    public static void main(String[] args) {

        Map<String, String> map = new ConcurrentHashMap<>();

        Map unsafeMap = new HashMap();
        Map threadSafeMap = Collections.synchronizedMap(unsafeMap);
//        它实际上是用一个包装类包装了非线程安全的Map，然后对所有读写方法都用synchronized加锁，
//        这样获得的线程安全集合的性能比java.util.concurrent集合要低很多，所以不推荐使用。
    }
}
