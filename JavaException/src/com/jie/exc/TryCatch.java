package com.jie.exc;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TryCatch {
    public static void main(String[] args) {
//        如果是测试代码，上面的写法就略显麻烦。如果不想写任何try代码，可以直接把main()方法定义为throws Exception
//        main()方法声明了可能抛出Exception，也就声明了可能抛出所有的Exception，
//        因此在内部就无需捕获了。代价就是一旦发生异常，程序会立刻退出


        //在定义时只声明可能抛出异常而不捕获，那就需要在调用时捕获
        byte[] bs = new byte[0];
//        只要是方法声明的Checked Exception，不在调用层捕获，也必须在更高的调用层捕获。
//        所有未捕获的异常，最终也必须在main()方法中捕获，
//        不会出现漏写try的情况。这是由编译器保证的。main()方法也是最后捕获Exception的机会

        try {
            bs = toGBK("中文");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
//          即使捕获异常后不知如何处理，至少也要先记录下来  利用 e.printStackTrace();可以打印出方法的调用栈
        }
        System.out.println(Arrays.toString(bs));
    }

//    static byte[] toGBK(String s) {
//        return s.getBytes("GBK");
//    }


    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");
        //在方法定义处用throws表示toGBK()方法可能会抛出UnsupportedEncodingException，
        // 就可以让toGBK()方法通过编译器检查
    }

//    static byte[] toGBK(String s) {
//        try {
//            // 用指定编码转换String为byte[]:
//            return s.getBytes("GBK");
//        } catch (UnsupportedEncodingException e) {
//            // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
//            System.out.println(e); // 打印异常信息
//            return s.getBytes(); // 尝试使用用默认编码
//        }
//    }
}

/*
* String.getBytes(String)方法定义是：
* public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {……}
*
* 方法定义的时候，使用throws Xxx表示该方法可能抛出的异常类型。
* 调用方在调用的时候，必须强制捕获这些异常，否则编译器会报错。
*
* */