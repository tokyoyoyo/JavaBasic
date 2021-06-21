package com.jie.gen;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GetFatherT {
    public static void main(String[] args) {
        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
            Type firstType = types[0]; // 取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // Integer
        }
    }
}


class Pair5<T> {
    private T first;
    private T last;
    public Pair5(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
}

class IntPair extends Pair5<Integer> {
    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}