package com.VariablesAndDataTypes;

public class BooleanCalc {
    public static void main(String[] args) {
        //判断指定年龄是否是小学生（6～12岁）：
        int age = 7;

        boolean isPrimaryStudent = age>=6 && age<=12;
        System.out.println(isPrimaryStudent ? "Yes" : "No");
    }
}
