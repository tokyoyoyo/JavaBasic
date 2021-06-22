package com.jie.NewAPI;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeTest {
    public static void main(String[] args) {

        System.out.println("通过now()方法返回当前时间");
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
        System.out.println(zbj);
        System.out.println(zny);
        System.out.println();


        System.out.println("另一种方式是通过给一个LocalDateTime附加一个ZoneId，就可以变成ZonedDateTime===========");
        LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        ZonedDateTime zbj2 = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zny2 = ldt.atZone(ZoneId.of("America/New_York"));
        System.out.println(zbj2);
        System.out.println(zny2);


        System.out.println("北京转换时间===================");
        // 以中国时区获取当前时间:
        zbj = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        // 转换为纽约时间:
        zny = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);




//        有了ZonedDateTime，将其转换为本地时间就非常简单：
        System.out.println("转换为本地时间");
        ZonedDateTime zdt = zny;
        LocalDateTime ldt2 = zdt.toLocalDateTime();
        System.out.println(ldt2);

//        转换为LocalDateTime时，直接丢弃了时区信息







        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
        // test:
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }


    }



    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {

        return bj.atZone(ZoneId.of("Asia/Shanghai"))
                .withZoneSameInstant(ZoneId.of("America/New_York"))
                .plusHours(h).plusMinutes(m).toLocalDateTime();
    }




}
