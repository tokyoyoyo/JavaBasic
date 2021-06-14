package com.VariablesAndDataTypes;

public class ArraryTest {
    public static void main(String[] args) {
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"?
        /*
        原来names[1]指向的字符串"XYZ"并没有改变，
        仅仅是将names[1]的引用从指向"XYZ"改成了指向"cat"，
        结果是字符串"XYZ"再也无法通过names[1]访问到了
        * */
    }
}
