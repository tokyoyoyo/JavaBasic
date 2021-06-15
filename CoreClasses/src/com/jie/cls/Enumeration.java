package com.jie.cls;

public class Enumeration {
    public static void main(String[] args) {

//        int day =6;
//        if (day == Weekday.SAT || day == Weekday.SUN) {
//            // TODO: work at home
//            System.out.println("work at home");
//        }

//        String color = "r";
//        if (Color.RED.equals(color)) {
//            // TODO:
//            System.out.println("这是红色");
//        }



        Weekday day = Weekday.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Today is " + day + ". Work at home!");
        } else {
            System.out.println("Today is " + day + ". Work at office!");
        }

        switch(day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }

//        if (day == Weekday.SAT || day == Weekday.SUN) {
//            System.out.println("Work at home!");
//        } else {
//            System.out.println("Work at office!");
//        }

//        if (day.dayValue == 6 || day.dayValue == 0) {
//            System.out.println("Work at home!");
//        } else {
//            System.out.println("Work at office!");
//        }


        System.out.println(Weekday.SUN.name());     //name(),返回常量名

        System.out.println(Weekday.MON.ordinal());

    }

}

enum Weekday {

//    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);
//    定义private的构造方法，并且，给每个枚举常量添加字段
    //SUN, MON, TUE, WED, THU, FRI, SAT;

    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
//    enum常量本身带有类型信息,编译器会自动检查出类型错误
//    不同类型的枚举不能互相比较或者赋值

//    enum类型的每个常量在JVM中只有一个唯一实例，所以可以直接用==
}
//枚举是特殊的类
//    定义的enum类型总是继承自java.lang.Enum，且无法被继承；
//    只能定义出enum的实例，而无法通过new操作符创建enum的实例；
//    定义的每个实例都是引用类型的唯一实例；
//    可以将enum类型用于switch语句。





//class Weekday {
//    public static final int SUN = 0;
//    public static final int MON = 1;
//    public static final int TUE = 2;
//    public static final int WED = 3;
//    public static final int THU = 4;
//    public static final int FRI = 5;
//    public static final int SAT = 6;
//}
//
//class Color {
//    public static final String RED = "r";
//    public static final String GREEN = "g";
//    public static final String BLUE = "b";
//}