package com.jie.sync;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//如果有线程正在读，写线程需要等待读线程释放锁后才能获取写锁，即读的过程中不允许写，这是一种悲观的读锁。

public class ReadWriteLockTest {
        private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
        private final Lock rlock = rwlock.readLock();
        private final Lock wlock = rwlock.writeLock();
        private int[] counts = new int[10];

        public void inc(int index) {
            wlock.lock(); // 加写锁
            try {
                counts[index] += 1;
            } finally {
                wlock.unlock(); // 释放写锁
            }
        }

        public int[] get() {
            rlock.lock(); // 加读锁
            try {
                return Arrays.copyOf(counts, counts.length);
            } finally {
                rlock.unlock(); // 释放读锁
            }
        }

}
