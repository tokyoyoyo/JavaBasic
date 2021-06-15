package com.jie.obj;

public class Polymorphic {
    public static void main(String[] args) {
        Person p = new Student();
        p.run(); // 应该打印Person.run还是Student.run?


        Income[] incomes = new Income[] {
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
//        多态允许添加更多类型的子类实现功能扩展，却不需要修改基于父类的代码
        System.out.println(totalTax(incomes));
    }
    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income: incomes) {
            total = total + income.getTax();
        }
        return total;
    }

//运行期才能动态决定调用的子类方法。对某个类型调用某个方法，执行的实际方法可能是某个子类的覆写方法

//    因为所有的class最终都继承自Object，而Object定义了几个重要的方法：
//
//    toString()：把instance输出为String；
//    equals()：判断两个instance是否逻辑相等；
//    hashCode()：计算一个instance的哈希值。

}
class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax() {
        return income * 0.1; // 税率10%
    }
}

class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}
/*
调用super
在子类的覆写方法中，如果要调用父类的被覆写的方法，可以通过super来调用。

final
继承可以允许子类覆写父类的方法。如果一个父类不允许子类对它的某个方法进行覆写，可以把该方法标记为final。用final修饰的方法不能被Override：

如果一个类不希望任何其他类继承自它，那么可以把这个类本身标记为final。用final修饰的类不能被继承：
对于一个类的实例字段，同样可以用final修饰。用final修饰的字段在初始化后不能被修改。
在构造方法中初始化final字段更为常用，因为可以保证实例一旦创建，其final字段就不可修改

* */