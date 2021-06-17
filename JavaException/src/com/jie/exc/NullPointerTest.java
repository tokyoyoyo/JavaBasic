package com.jie.exc;

public class NullPointerTest {
    /*
    成员变量在定义时初始化
    使用空字符串""而不是默认的null可避免很多NullPointerException，编写业务逻辑时，用空字符串""表示未填写比null安全得多
    可以使得调用方无需检查结果是否为null
    如果调用方一定要根据null判断，比如返回null表示文件不存在，那么考虑返回Optional<T>
    调用方必须通过Optional.isPresent()判断是否有结果


     */

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.address.city.toLowerCase());
    }
}


class Person {
    String[] name = new String[2];
    Address address = new Address();
}

class Address {
    String city;
    String street;
    String zipcode;
}