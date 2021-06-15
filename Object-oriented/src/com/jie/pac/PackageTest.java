package com.jie.pac;


import com.jie.obj.Worker;

public class PackageTest {
    Worker worker = new Worker("liQiang",22);
}

//Java编译器最终编译出的.class文件只使用完整类名，因此，在代码中，当编译器遇到一个class名称时：
//        如果是完整类名，就直接根据完整类名查找这个class；
//        如果是简单类名，按下面的顺序依次查找：
//        查找当前package是否存在这个class；
//        查找import的包是否包含这个class；
//        查找java.lang包是否包含这个class。




//编写class的时候，编译器会自动帮我们做两个import动作：
//
//        默认自动import当前package的其他class；
//
//        默认自动import java.lang.*。


//如果有两个class名称相同，例如，mr.jun.Arrays和java.util.Arrays，那么只能import其中一个，另一个必须写完整类名。

//Java内建的package机制是为了避免class命名冲突；
//
//        JDK的核心类使用java.lang包，编译器会自动导入；
//
//        JDK的其它常用类定义在java.util.*，java.math.*，java.text.*，……；
//
//        包名推荐使用倒置的域名，例如org.apache。

