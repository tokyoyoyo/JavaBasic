package com.jie.byteIO;

import java.io.*;

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {


        OutputStream output = new FileOutputStream("JavaIOTest\\src\\readme.txt");
        output.write(72); // H
        output.write(101); // e
        output.write(108); // l
        output.write(108); // l
        output.write(111); // o



        System.out.println();
        System.out.println("===========================");
        System.out.println();


        output.write("\nthis is a good night . 你觉得呢？".getBytes("UTF-8")); // Hello
        output.close();


        System.out.println();
        System.out.println("===========================");
        System.out.println();


        try (OutputStream output2 = new FileOutputStream("JavaIOTest\\\\src\\\\readme.txt")) {
            output2.write("\nHello".getBytes("UTF-8")); // Hello
        } // 编译器在此自动为我们写入finally并调用close()



        System.out.println();
        System.out.println("===========================");
        System.out.println();



        byte[] data;
        try (ByteArrayOutputStream output2 = new ByteArrayOutputStream()) {
            output2.write("Hello ".getBytes("UTF-8"));
            output2.write("world!".getBytes("UTF-8"));
            data = output2.toByteArray();
        }
        System.out.println(new String(data, "UTF-8"));


        System.out.println();
        System.out.println("===========================");
        System.out.println();



        try (InputStream in = new FileInputStream("JavaIOTest\\src\\input.txt");
             OutputStream out = new FileOutputStream("JavaIOTest\\src\\output.txt"))
        {
            byte[]  data2 = new byte[1000];
            int n = in.read(data2);
            out.write(data2 ,0 , n);
        }
    }
}
