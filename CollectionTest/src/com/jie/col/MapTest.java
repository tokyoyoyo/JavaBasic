package com.jie.col;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Student s = new Student("Xiao Ming", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
        Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
        System.out.println(target == s); // true，同一个实例
        System.out.println(target.score); // 99
        Student another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null

        System.out.println();

        System.out.println("对同一个key调用两次put()方法，分别放入不同的value");
        System.out.println("一个key只能关联一个value:");
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 123);
        map2.put("pear", 456);
        System.out.println(map2.get("apple")); // 123
        map2.put("apple", 789); // 再次放入apple作为key，但value变为789
        System.out.println(map2.get("apple")); // 789


        System.out.println("遍历Map时，不可假设输出的key是有序的！");
        Map<String, Integer> map3 = new HashMap<>();
        map3.put("apple", 123);
        map3.put("pear", 456);
        map3.put("banana", 789);
        for (Map.Entry<String, Integer> entry : map3.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }

}
class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}


/*
            要正确使用HashMap，作为key的类必须正确覆写equals()和hashCode()方法；

            一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：

            如果equals()返回true，则hashCode()返回值必须相等；

            如果equals()返回false，则hashCode()返回值尽量不要相等。

            实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。
 */