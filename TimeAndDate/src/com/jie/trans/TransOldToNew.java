package com.jie.trans;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TransOldToNew {
    public static void main(String[] args) {

        System.out.println("旧转新=======================");
        // Date -> Instant:
        Instant ins1 = new Date().toInstant();

// Calendar -> Instant -> ZonedDateTime:
        Calendar calendar = Calendar.getInstance();
        Instant ins2 = calendar.toInstant();
        ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());



        System.out.println("新转旧===============");
        // ZonedDateTime -> long:
        ZonedDateTime zdt2 = ZonedDateTime.now();
        long ts = zdt2.toEpochSecond() * 1000;

// long -> Date:
        Date date = new Date(ts);

// long -> Calendar:
        Calendar calendar2 = Calendar.getInstance();
        calendar2.clear();
        calendar2.setTimeZone(TimeZone.getTimeZone(zdt.getZone().getId()));
        calendar2.setTimeInMillis(zdt.toEpochSecond() * 1000);


        long ts3 = 1574208900000L;
        System.out.println(timestampToString(ts3, Locale.CHINA, "Asia/Shanghai"));
        System.out.println(timestampToString(ts3, Locale.US, "America/New_York"));

    }



    static String timestampToString(long epochMilli, Locale lo, String zoneId) {
        Instant ins = Instant.ofEpochMilli(epochMilli);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
    }



}
