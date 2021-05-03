package com.action;


import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * java 8 时间类测试
 */
public class LocalDateTest{

   public void testClock(){
       Clock clock = Clock.systemUTC();
       System.out.println(clock.millis());
       Long mills = Instant.now().toEpochMilli();
       System.out.println(mills);
       Long second = Instant.now().getEpochSecond();
       System.out.println(second);
       DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       String date = dateTimeFormatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(mills), ZoneId.systemDefault()));
       System.out.println(date);
   }

   public static void main(String[] args){
       LocalDateTest localDateTest = new LocalDateTest();
       localDateTest.testClock();
   }

}
