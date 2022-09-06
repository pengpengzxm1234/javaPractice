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

   public void localTimeTest(){
       LocalDateTime localDateTime = LocalDateTime.parse("2021-05-31 12:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
       System.out.println(localDateTime.toString());
       System.out.println(localDateTime.getYear());
       System.out.println(localDateTime.getMonthValue());
       System.out.println(localDateTime.getDayOfMonth());
   }
    public Long localDateString2LocalDateMinute(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static LocalDateTime localDateString2LocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);
    }


    public Long getYYYY_MM_DD_HH_MM_FromTimestampMinute(Long timestamp){
        if (timestamp == null) {
            return null;
        }
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String format = localDateTime.format(formatter);
        return Long.valueOf(format);
    }

    public void testPlusMonth(){
       LocalDateTime localDateTime = LocalDateTime.now();
       System.out.println(localDateTime.plusMonths(1L).isAfter(localDateTime));
    }

   public static void main(String[] args){
       LocalDateTest localDateTest = new LocalDateTest();
       //localDateTest.localTimeTest();
       //System.out.println(localDateTest.getYYYY_MM_DD_HH_MM_FromTimestampMinute(System.currentTimeMillis()));
//       System.out.println(localDateTest.localDateString2LocalDateMinute("20191220144140"));
//
//       LocalDateTime data = localDateTest.localDateString2LocalDateTime("2021-01-01 12:12:12");
//      System.out.println(data.toString());
       localDateTest.testPlusMonth();
   }

}
