package com.jie.NewAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeTest {
    public static void main(String[] args) {

        System.out.println("LocalDateTime==============================");
        LocalDate d = LocalDate.now(); // 当前日期
        LocalTime t = LocalTime.now(); // 当前时间
        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        System.out.println(d); // 严格按照ISO 8601格式打印
        System.out.println(t); // 严格按照ISO 8601格式打印
        System.out.println(dt); // 严格按照ISO 8601格式打印



        // 自定义格式化:
        System.out.println("自定义格式化=========================================");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));
        System.out.println(LocalDateTime.now());


        System.out.println("对某一天进行计算=======================");

        // 本月第一天0:00时刻:
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);

        // 本月最后1天:
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);

        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);

        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);

        // 用自定义格式解析:
        LocalDateTime dt0 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dt0);


        System.out.println("时间加减==================================");
        LocalDateTime dt1 = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt1);
        // 加5天减3小时:
        LocalDateTime dt2 = dt1.plusDays(5).minusHours(3);
        System.out.println(dt2); // 2019-10-31T17:30:59
        // 减1月:
        LocalDateTime dt3 = dt2.minusMonths(1);
        System.out.println(dt3); // 2019-09-30T17:30:59


        System.out.println("with方法对日期和时间调整==================");
        System.out.println(dt);
        // 日期变为12日:
        LocalDateTime dt4 = dt.withDayOfMonth(12);
        System.out.println(dt4);
        // 月份变为9:
        LocalDateTime dt5 = dt4.withMonth(9);
        System.out.println(dt5);


        System.out.println("比较先后==================");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        System.out.println(now.isBefore(target));
        System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
        System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));


        System.out.println("时间的差值======================");
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration da = Duration.between(start, end);
        System.out.println(da); // PT1235H10M30S

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        System.out.println(p); // P1M21D



    }
}
