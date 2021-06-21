package com.jie.charIO;

import java.io.*;

import static java.nio.charset.StandardCharsets.*;

public class ReaderTest {
    public static void main(String[] args) throws IOException {

        // 创建一个FileReader对象:
        Reader reader = new FileReader("JavaIOTest\\src\\readme.txt"); // 字符编码是???
        for (;;) {
            int n = reader.read(); // 反复调用read()方法，直到返回-1
            if (n == -1) {
                break;
            }
            System.out.print((char)n); // 打印char
        }

        reader.close(); // 关闭流


        System.out.println();
        System.out.println();


        try (Reader inputStreamReader = new InputStreamReader(new FileInputStream("JavaIOTest\\src\\readme.txt"), UTF_8)){
            char[] buffer = new char[1000];
            int n;
            while ((n = inputStreamReader.read(buffer)) != -1) {
                System.out.println("read " + n + " chars.");
            }
        }

        System.out.println();


//        CharArrayReader可以在内存中模拟一个Reader，它的作用实际上是把一个char[]数组变成一个Reader，
//        这和ByteArrayInputStream非常类似：

        try (Reader reader2 = new CharArrayReader("Hello".toCharArray())) {
        }


//        StringReader可以直接把String作为数据源，它和CharArrayReader几乎一样：

        try (Reader reader3 = new StringReader("Hello")) {
        }

    }
}
