package com.jie.obj;

//继承是is关系，组合是has关系
public class ExtendTest {
    // 不要重复name和age字段/方法,
    // 只需要定义新增score字段/方法:

//    protected      子类无法访问父类的private字段或者private方法
//    这使得继承的作用被削弱了。为了让子类可以访问父类的字段，把private改为protected。用protected修饰的字段可以被子类访问：
//    protected关键字可以把字段和方法的访问权限控制在继承树内部，一个protected字段和方法可以被其子类，以及子类的子类所访问
//    子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。
//    如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法。


    public static void main(String[] args) {

//        向上转型，多态
        Student s0 = new Student();
        Person p0 = s0; // upcasting, ok
        Object o1 = p0; // upcasting, ok
        Object o2 = s0; // upcasting, ok
        //    如果把一个父类类型强制转型为子类类型，就是向下转型（downcasting）
        Person p1 = new Student(); // upcasting, ok
        Person p2 = new Person();
        Student s1 = (Student) p1; // ok
        //Student s2 = (Student) p2; // runtime error! ClassCastException!

//        instanceof操作符，可以先判断一个实例究竟是不是某种类型：
//        判断一个变量所指向的实例是否是指定类型，或者这个类型的子类。如果一个引用变量为null，那么对任何instanceof的判断都为false。
        Person p3 = new Person();

        System.out.println(p3 instanceof Person); // true
        System.out.println(p3 instanceof Student); // false

        Student s3 = new Student();
        System.out.println(s3 instanceof Person); // true
        System.out.println(s3 instanceof Student); // true

        Student n = null;
        System.out.println(n instanceof Student); // false

        Person p4 = new Student();
        if (p4 instanceof Student) {
            // 只有判断成功才会向下转型:
            Student s4 = (Student) p4; // 一定会成功
        }
    }


}

class Student extends Person{
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void run() {
        System.out.println("Student.run");
    }
}
//Person称为超类（super class），父类（parent class），基类（base class），
// 把ExtendTest称为子类（subclass），扩展类（extended class）

//在Java中，没有明确写extends的类，编译器会自动加上extends Object。
// 所以，任何类，除了Object，都会继承自某个类。下图是Person、Student的继承树


//Java只允许一个class继承自一个类，因此，一个类有且仅有一个父类。只有Object特殊，它没有父类。
