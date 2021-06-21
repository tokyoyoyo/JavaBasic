package com.jie.byteIO;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("JavaIOTest\\\\src\\\\readme.txt");

        for (;;){
            int n = inputStream.read();

            if (n == -1) {
                break;
            }
            System.out.println(n);
        }
        inputStream.close();


        System.out.println();
        System.out.println("===========================");
        System.out.println();

        InputStream input = null;
        try {
            input = new FileInputStream("JavaIOTest\\src\\readme.txt");
            int n;
            while ((n = input.read()) != -1) { // 利用while同时读取并判断
                System.out.print((char)n);
            }
        } finally {
            if (input != null) { input.close(); }
        }



        System.out.println();
        System.out.println("===========================");
        System.out.println();



        try (InputStream input2 = new FileInputStream("JavaIOTest\\src\\readme.txt")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input2.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes. : ");
            }
        }



        System.out.println();
        System.out.println("===========================");
        System.out.println();


        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream input3 = new ByteArrayInputStream(data)) {
            int n;
            while ((n = input3.read()) != -1) {
                System.out.print((char)n);
            }
        }



        System.out.println();
        System.out.println("===========================");
        System.out.println();


        String s;
        try (InputStream input4 = new FileInputStream("JavaIOTest\\src\\readme.txt")) {
            int n;
            StringBuilder sb = new StringBuilder();
            while ((n = input4.read()) != -1) {
                sb.append((char) n);
            }
            s = sb.toString();
        }
        System.out.println(s);



        System.out.println();
        System.out.println("===========================");
        System.out.println();



        try (InputStream input5 = new FileInputStream("JavaIOTest\\src\\readme.txt")) {
            s = readAsString(input5);
        }
        System.out.println("readAsString : " + s);


        System.out.println();
        System.out.println("===========================");
        System.out.println();



        try ( InputStream input5 = new ByteArrayInputStream(data)) {
            s = readAsString(input5);
            System.out.println("readAsString(input5)  : " + s);
        }


    }


    public static String readAsString(InputStream input) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = input.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }



}
