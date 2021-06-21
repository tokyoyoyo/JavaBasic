package com.jie.byteIO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SerializableTest {
    public static void main(String[] args) throws IOException {

//        把一个Java对象变为byte[]数组，需要使用ObjectOutputStream。它负责把一个Java对象写入一个字节流：
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)){
            objectOutputStream.writeInt(123456);
            objectOutputStream.writeUTF("hello");
            objectOutputStream.writeObject(Double.valueOf("1234.567"));

            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
        }
    }
}


/*

        一个Java对象要能序列化，必须实现一个特殊的java.io.Serializable接口，它的定义如下：

                public interface Serializable {
                }
        Serializable接口没有定义任何方法，它是一个空接口。我们把这样的空接口称为“标记接口”（Marker Interface），
        实现了标记接口的类仅仅是给自身贴了个“标记”，并没有增加任何方法。
 */