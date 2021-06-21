package com.jie.charIO;

import java.io.*;

public class WriterTest {
    public static void main(String[] args) throws IOException {


        try (Writer writer = new FileWriter("JavaIOTest\\src\\readme.txt")) {
            writer.write("H\n"); // 写入单个字符
            writer.write("Hello\n".toCharArray()); // 写入char[]
            writer.write("Hello"); // 写入String
        }



        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write(65);
            writer.write(66);
            writer.write(67);
            char[] data = writer.toCharArray(); // { 'A', 'B', 'C' }
            System.out.println(data);
        }


    }
}
