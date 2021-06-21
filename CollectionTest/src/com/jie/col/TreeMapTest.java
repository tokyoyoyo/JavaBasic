package com.jie.col;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // apple, orange, pear



        Map<Pers, Integer> map2 = new TreeMap<>(new Comparator<Pers>() {
            public int compare(Pers p1, Pers p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        map2.put(new Pers("Tom"), 1);
        map2.put(new Pers("Bob"), 2);
        map2.put(new Pers("Lily"), 3);
        for (Pers key : map2.keySet()) {
            System.out.println(key);
        }
        // {Person: Bob}, {Person: Lily}, {Person: Tom}
        System.out.println(map2.get(new Pers("Bob"))); // 2

    }
}



class Pers {
    public String name;
    Pers(String name) {
        this.name = name;
    }
    public String toString() {
        return "{Person: " + name + "}";
    }
}
