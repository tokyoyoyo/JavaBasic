package com.ProcessControl;

public class SwitchTest {
    public static void main(String[] args) {
        //switch语句根据switch (表达式)计算的结果，跳转到匹配的case结果，然后继续执行后续语句，直到遇到break结束执行。

//        int option = 99;
//        switch (option) {
//            case 1:
//                System.out.println("Selected 1");
//                break;
//            case 2:
//                System.out.println("Selected 2");
//                break;
//            case 3:
//                System.out.println("Selected 3");
//                break;
//        }
        //加了break的 switch可以翻译成if,但对于多个==判断的情况，使用switch结构更加清晰。


//        int option = 99;
//        switch (option) {
//            case 1:
//                System.out.println("Selected 1");
//                break;
//            case 2:
//                System.out.println("Selected 2");
//                break;
//            case 3:
//                System.out.println("Selected 3");
//                break;
//            default:
//                System.out.println("Not selected");
//                break;
//        }

        //case语句具有“穿透性”，漏写break将导致意想不到的结果：


//        int option = 2;
//        switch (option) {
//            case 1:
//                System.out.println("Selected 1");
//            case 2:
//                System.out.println("Selected 2");
//            case 3:
//                System.out.println("Selected 3");
//            default:
//                System.out.println("Not selected");
//        }

        //如果有几个case语句执行的是同一组语句块，可以合并：

//        int option = 2;
//        switch (option) {
//            case 1:
//                System.out.println("Selected 1");
//                break;
//            case 2:
//            case 3:
//                System.out.println("Selected 2, 3");
//                break;
//            default:
//                System.out.println("Not selected");
//                break;
//        }

        //只要保证有break，case的顺序不影响程序逻辑：


        //switch语句还可以匹配字符串。比较内容是否相等，而不是引用的内容

        String fruit = "apple";
        switch (fruit) {
            case "apple":
                System.out.println("Selected apple");
                break;
            case "pear":
                System.out.println("Selected pear");
                break;
            case "mango":
                System.out.println("Selected mango");
                break;
            default:
                System.out.println("No fruit selected");
                break;
        }


    }
}
