package com.jie.cls;



public class StringTest {
//    String是一个引用类型,在Java中是不可变得
    String st="Hello";
//    这种不可变性是通过内部的private final char[]字段，以及没有任何修改char[]的方法实现的。
//    Java编译器对String有特殊处理，即可以直接用"..."来表示一个字符串：

    //字符串的比较要用equals，==比较的是地址
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();

        System.out.println("s1 = \"hello\"");
        System.out.println("s2 = \"HELLO\".toLowerCase()");

        System.out.println("============字符串的比较=================");
        System.out.printf("s1 == s2   =  ");
        System.out.println(s1 == s2);
        System.out.println("s1.equals(s2)    =  "+ s1.equals(s2));
        System.out.println();

        // 是否包含子串:

        System.out.println(" ================是否包含子串:=================");
        System.out.println("\"Hello\".contains(\"ll\")    =  "+"Hello".contains("ll"));
        System.out.println();
        System.out.println("\"Hello\".indexOf(\"l\")    =  "+"Hello".indexOf("l"));
        System.out.println("\"Hello\".lastIndexOf(\"l\")     =  "+"Hello".lastIndexOf("l"));
        System.out.println("\"Hello\".startsWith(\"He\")    =  "+"Hello".startsWith("He"));
        System.out.println("\"Hello\".endsWith(\"lo\")     =  "+"Hello".endsWith("lo"));

        System.out.println();
//提取子串的例子：

        System.out.println("=====================提取子串的例子====================");
        System.out.println("\"Hello\".substring(2)    =  "+ "Hello".substring(2));
        System.out.println("\"Hello\".substring(2, 4)    =  "+"Hello".substring(2, 4));//"ll",注意索引号是从0开始的。

//        去除首尾空白字符
//        trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n
//        trim()并没有改变字符串的内容，而是返回了一个新字符串
        System.out.println("  \tHello\r\n ".trim());

//        String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
        System.out.println("\"\".isEmpty()   =  "+"".isEmpty());
        System.out.println("\"  \".isEmpty()  =  " + "  ".isEmpty());
        System.out.println();


//        替换子串

        System.out.println("===============替换子串：==============");
        String s = "hello";
        System.out.println("s = \"hello\"");
        System.out.println("s.replace('l', 'w')  =  "+s.replace('l', 'w'));

        System.out.println("s.replace(\"ll\", \"~~\")  =  "+s.replace("ll", "~~"));
        System.out.println();
        //分割字符串
        System.out.println("==========分割字符串:===============");
        String[] ls = s.split("e");
        for (String ll:ls) {
            System.out.println(ll);
        }
        System.out.println();
//        拼接字符串

        System.out.println("=========拼接字符串=========");
        String[] arr = {"A", "B", "C"};
        String sp = String.join("$", arr);
        System.out.println(sp);
        System.out.println();

//        格式化字符串
        System.out.println("============格式化字符串===============");
        String sg = "Hi %s, your score is %d!";
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
        System.out.println();

//        类型转换
        System.out.println("==========类型转换===============");

        System.out.println("String.valueOf(123)  =  " + String.valueOf(123));
        System.out.println("String.valueOf(45.67)  =  " + String.valueOf(45.67));
        System.out.println("String.valueOf(true)  =  " + String.valueOf(true));
        System.out.println("String.valueOf(new Object())  =  " + String.valueOf(new Object()));



    }




}
