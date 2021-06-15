package com.jie.obj;
//抽象方法本质上是定义接口规范：即规定高层类的接口，从而保证所有子类都有相同的接口实现，这样，多态就能发挥出威力。
public interface InterfaveTest {
//    接口定义的所有方法默认都是public abstract的，

//    当一个具体的class去实现一个interface时，需要使用implements关键字

//    抽象类单继承，接口多实现

//    default方法
//    在接口中，可以定义default方法。
//    实现类可以不必覆写default方法。default方法的目的是，当我们需要给接口新增一个方法时，
//    会涉及到修改全部子类。如果新增的是default方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。

    public static final int MALE = 1;
    public static final int FEMALE = 2;
//    interface是一个纯抽象类，所以它不能定义实例字段。但是，interface是可以有静态字段的，并且静态字段必须为final类型
//    interface的字段只能是public static final类型，所以可以把修饰符都去掉，

}
