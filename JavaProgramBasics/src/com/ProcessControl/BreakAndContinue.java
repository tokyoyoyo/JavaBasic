package com.ProcessControl;

public class BreakAndContinue {

    public static void main(String[] args) {



//        int sum =0;
//        for( int i =1 ; ; i++){
//            sum = sum + i;
//            if (i == 100) {
//                break;
//            }
//        }
//        System.out.println(sum);

//        for (int i=1; i<=10; i++) {
//            System.out.println("i = " + i);
//            for (int j=1; j<=10; j++) {
//                System.out.println("j = " + j);
//                if (j >= i) {
//                    break;
//                }
//            }
//            // break跳到这里,break语句总是跳出自己所在的那一层循环
//            System.out.println("breaked");
            //break语句位于内层的for循环，因此，它会跳出内层for循环，但不会跳出外层for循环


            //continue是提前结束本次循环，直接继续执行下次循环
        int sum = 0;
        for (int i=1; i<=10; i++) {
            System.out.println("begin i = " + i);
            if (i % 2 == 0) {
                continue; // continue语句会结束本次循环
            }
            sum = sum + i;
            System.out.println("end i = " + i);
        }
        System.out.println(sum); // 25




    }

}
