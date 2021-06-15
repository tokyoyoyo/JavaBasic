package com.jie.obj;

public class AbstractClass {
//    如果父类的方法本身不需要实现任何功能，仅仅是为了定义方法签名，目的是让子类去覆写它，那么，可以把父类的方法声明为抽象方法

//    把一个方法声明为abstract，表示它是一个抽象方法,本身没有实现任何方法语句
//    包含抽象方法的类也必须加上abstract关键字，表示这个类是含有抽象方法的。

//    抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。因此，抽象方法实际上相当于定义了“规范”。

//    尽量引用高层类型，避免引用实际子类型的方式，称之为面向抽象编程。

//    面向抽象编程的本质就是：
//
//    上层代码只定义规范（例如：abstract class Person）；
//
//    不需要子类就可以实现业务逻辑（正常编译）；
//
//    具体的业务逻辑由不同的子类实现，调用者并不关心。
}
