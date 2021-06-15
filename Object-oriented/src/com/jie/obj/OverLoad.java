package com.jie.obj;

public class OverLoad {

//    方法名相同，但各自的参数不同，称为方法重载 Overload
//    重载的返回值类型通常都是相同的，也可以不同。
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }

    public static void main(String[] args) {
        Perso ming = new Perso();
        Perso hong = new Perso();
        ming.setName("Xiao Ming");
        // TODO: 给Person增加重载方法setName(String, String):
        hong.setName("Xiao", "Hong");
        System.out.println(ming.getName());
        System.out.println(hong.getName());
    }

}

class Perso {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String name,String name2) {
        this.name = name+name2;
    }
}