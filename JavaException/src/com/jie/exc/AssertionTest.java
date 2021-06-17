package com.jie.exc;

public class AssertionTest {
    public static void main(String[] args) {
        double x = -1;

//        断言条件x >= 0预期为true。如果计算结果为false，则断言失败，抛出AssertionError
        assert x >= 0 : "x must >= 0";
//        AssertionError会带上消息x must >= 0，更加便于调试

        System.out.println(x);

        //要执行assert语句，必须给Java虚拟机传递-enableassertions（可简写为-ea）参数启用断言。
//        所以，程序必须在命令行下运行才有效果
//        还可以有选择地对特定地类启用断言，命令行参数是：-ea:com.itranswarp.sample.Main，
//        表示只对com.itranswarp.sample.Main这个类启用断言。

//        或者对特定地包启用断言，命令行参数是：-ea:com.itranswarp.sample...（注意结尾有3个.），
//        表示对com.itranswarp.sample这个包启动断言

//        其实断言基本不用
    }
}
