package cn.com.time.jdk.lang.date;

import cn.com.time.jdk.base.BaseTest;
import org.springframework.cglib.core.Local;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Created on 202017/9/30 13:53 By tong.luo
 * <p>
 * Copyright @ 2017 Tima Networks Inc. All Rights Reserved. 
 */
public class DateTest extends BaseTest{

    /**
     * LocalDate相关
     */
    public static void t1(){
        LocalDate today=LocalDate.now();
        print("today:"+today);
        LocalDate targetDay=LocalDate.of(2017,9,11);
        print("targetDay:"+targetDay);
        LocalDate parseDay=LocalDate.parse("2017-09-30");
        print("parseDay:"+parseDay);
        //取本月第一天
        LocalDate firstDayOfMonth=today.with(TemporalAdjusters.firstDayOfMonth());
        print("firstDayOfMonth:"+firstDayOfMonth);
        //取本月第二天
        LocalDate secondDayOfMonth=today.withDayOfMonth(2);
        print("secondDayOfMonth:"+secondDayOfMonth);
        //取本月的最后一天
        LocalDate lastOfMonth=today.with(TemporalAdjusters.lastDayOfMonth());
        print("lastOfMonth:"+lastOfMonth);
        //取下一天
        LocalDate nextDay=today.plusDays(1);
        //取2017年一月的第一个周一
        LocalDate day=LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }

    /**
     * LocalTime只包含时间，获得当前时间
     */
    public static void t2(){
        LocalTime now=LocalTime.now();
        LocalTime zero=LocalTime.of(0,0,0);
        LocalTime mid=LocalTime.parse("12:00:00");
    }

    /**
     * JDBC
     */
    public static void t3(){
        /**
         * SQL->JAVA
         *
         * date->LocalDate
         *
         * time->LocalTime
         *
         * timestamp->LocalDateTime
         */
    }

    /**
     * Instant
     */
    public static void t4(){
        Instant i1=Instant.now();
        //毫秒
        long mills=i1.toEpochMilli();
        Instant i2=Instant.ofEpochMilli(mills);
        Date date=new Date();
        Instant i3=date.toInstant();
        Date d=new Date(i3.toEpochMilli());
    }

}
