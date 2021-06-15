package com.jie.cls;

import java.math.BigDecimal;

//BigDecimal可以表示一个任意大小且精度完全准确的浮点数
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); // 15241.55677489




//        scale()表示小数位数，例如：

//        BigDecimal d1 = new BigDecimal("123.45");
//        BigDecimal d2 = new BigDecimal("123.4500");
//        BigDecimal d3 = new BigDecimal("1234500");
//        System.out.println(d1.scale()); // 2,两位小数
//        System.out.println(d2.scale()); // 4
//        System.out.println(d3.scale()); // 0




//        stripTrailingZeros()方法，可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal

//        BigDecimal d1 = new BigDecimal("123.4500");
//        BigDecimal d2 = d1.stripTrailingZeros();
//        System.out.println(d1.scale()); // 4
//        System.out.println(d2.scale()); // 2,因为去掉了00

//        BigDecimal d3 = new BigDecimal("1234500");
//        BigDecimal d4 = d3.stripTrailingZeros();
//        System.out.println(d3.scale()); // 0
//        System.out.println(d4.scale()); // -2





//        BigDecimal可以设置它的scale，如果精度比原始值低，那么按照指定的方法进行四舍五入或者直接截断

//        BigDecimal d1 = new BigDecimal("123.456789");
//        BigDecimal d2 = d1.setScale(4, RoundingMode.HALF_UP); // 四舍五入，123.4568
//        BigDecimal d3 = d1.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567
//        System.out.println(d2);
//        System.out.println(d3);






//        BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，存在无法除尽的情况，这时，就必须指定精度以及如何进行截断

//        BigDecimal d1 = new BigDecimal("123.456");
//        BigDecimal d2 = new BigDecimal("23.456789");
//        BigDecimal d3 = d1.divide(d2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
//        BigDecimal d4 = d1.divide(d2); // 报错：ArithmeticException，因为除不尽






//        BigDecimal做除法的同时求余数：用这个方法判断两个BigDecimal是否是整数倍数

//        BigDecimal n = new BigDecimal("12.345");
//        BigDecimal m = new BigDecimal("0.12");
//        BigDecimal[] dr = n.divideAndRemainder(m);
//        System.out.println(dr[0]); // 102
//        System.out.println(dr[1]); // 0.105

//        BigDecimal n = new BigDecimal("12.75");
//        BigDecimal m = new BigDecimal("0.15");
//        BigDecimal[] dr = n.divideAndRemainder(m);
//        if (dr[1].signum() == 0) {
//            System.out.println("n是m的整数倍");
//        }





//            比较两个BigDecimal的值是否相等时，要特别注意，使用equals()方法不但要求两个BigDecimal的值相等，还要求它们的scale()相等：
//       TODO:不要用equals比较， 必须使用compareTo()方法来比较，它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于

        BigDecimal d1 = new BigDecimal("123.456");
        BigDecimal d2 = new BigDecimal("123.45600");
        System.out.println(d1.equals(d2)); // false,因为scale不同
        System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
        System.out.println(d1.compareTo(d2)); // 0

//        BigDecimal是通过一个BigInteger和一个scale来表示的，即BigInteger表示一个完整的整数，而scale表示小数位数：
//        public class BigDecimal extends Number implements Comparable<BigDecimal> {
//            private final BigInteger intVal;
//            private final int scale;
//        }

    }
}
