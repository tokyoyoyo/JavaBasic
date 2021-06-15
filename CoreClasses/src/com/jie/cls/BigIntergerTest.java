package com.jie.cls;

import java.math.BigInteger;
//BigInteger内部用一个int[]数组来模拟一个非常大的整数
public class BigIntergerTest {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("1234567890");
        System.out.println(bi.pow(5)); // 2867971860299718107233761438093672048294900000


//        对BigInteger做运算的时候，只能使用实例方法
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 12345678902469135780

//        转型到long
        BigInteger i = new BigInteger("123456789000");
        System.out.println(i.longValue()); // 123456789000
        //System.out.println(i.multiply(i).longValueExact());// java.lang.ArithmeticException: BigInteger out of long range
    }
}
