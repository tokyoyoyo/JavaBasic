package com.VariablesAndDataTypes;

public class RootFormula {
    public static void main(String[] args) {
        //一元二次方程ax^2+bx+c=0的求根公式
        double a = 1.0;
        double b = 3.0;
        double c = -4.0;

        double r1 = 0;
        double r2 = 0;

        double sj = b*b - 4*a*c;

        // 求平方根可用 Math.sqrt():
        if(sj <0){
            System.out.println("无解");
        }else if (sj>0){
            System.out.println("有双解");
            sj =Math.sqrt(sj);
            r1 = (sj-b)/(2*a);
            r2 = (-sj-b)/(2*a);
            System.out.println("r1 = "+ (int)r1);
            System.out.println("r2 = "+ r2);
        }else {
            System.out.println("有单解");
            r1= -b/(2*a);
            r2 = r1;
            System.out.println("r2 = "+ r2);
        }

    }
}
