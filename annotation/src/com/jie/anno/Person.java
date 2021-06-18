package com.jie.anno;





@Report(type=2, level="warning")
public class Person {
    @Range(min=1, max=15)
    public String name;

    @Range(max=10)
    public String city;

    public Person(String name) {
        this.name = name;
    }
}