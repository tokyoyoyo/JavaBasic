package com.jie.cls;

//        基本类型：byte，short，int，long，boolean，float，double，char
//        引用类型：所有class和interface类型
//引用类型可以赋值为null，表示空，但基本类型不能赋值为null

//java提供了包装类将八大基本类型转换为类，将首字母大写就能找到,都是final修饰的
public class PackagingClass {
    public static void main(String[] args) {
        int i = 100;
        // 通过new操作符创建Integer实例(不推荐使用,会有编译警告):
        Integer n1 = new Integer(i);
        // 通过静态方法valueOf(int)创建Integer实例:
        Integer n2 = Integer.valueOf(i);
//        Integer.valueOf()是静态工厂方法，它尽可能地返回缓存的实例以节省内存
        // 通过静态方法valueOf(String)创建Integer实例:
        Integer n3 = Integer.valueOf("100");
        System.out.println(n3.intValue());

//        Auto Boxing
//        int和Integer可以互相转换：
        Integer n = Integer.valueOf(i); //i = 100
        int x = n.intValue();

//        编译器可以帮助我们自动在int和Integer之间转型：
        Integer m = 100; // 编译器自动使用Integer.valueOf(int)
        int y = m; // 编译器自动使用Integer.intValue()
//        int变为Integer的赋值写法，称为自动装箱（Auto Boxing），反过来，把Integer变为int的赋值写法，称为自动拆箱

//        自动拆箱执行时可能会报NullPointerException：因为引用指向的为null
//        Integer n = null;
//        int i = n;


        //包装类定义的一些静态变量

        // boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
        Boolean t = Boolean.TRUE;
        Boolean f = Boolean.FALSE;
// int可表示的最大/最小值:
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648
// long类型占用的bit和byte数量:
        int sizeOfLong = Long.SIZE; // 64 (bits)
        int bytesOfLong = Long.BYTES; // 8 (bytes)


//        整数和浮点数的包装类型都继承自Number，因此，可以非常方便地直接通过包装类型获取各种基本类型
// 向上转型为Number:
        Number num = new Integer(999);
// 获取byte, int, long, float, double:
        byte b = num.byteValue();
        int q = num.intValue();
        long ln = num.longValue();
        float fl = num.floatValue();
        double d = num.doubleValue();





//Java中，并没有无符号整型（Unsigned）的基本数据类型，无符号整型和有符号整型的转换在Java中就需要借助包装类型的静态方法完成。
        byte x2 = -1;
        byte y2 = 127;
        System.out.println(Byte.toUnsignedInt(x2)); // 255
        System.out.println(Byte.toUnsignedInt(y2)); // 127


    }

}
