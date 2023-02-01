package com.hzb;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //0x01010001
        String tmp = "0x" + StringUtils.leftPad(Integer.toHexString(16842753).toUpperCase(), 8, '0');
        System.out.println( tmp );
        System.out.println("0x01010001");
        System.out.println(0000);

        Date time = getBeginTime(2022, 5);
        System.out.println(time);
    }

    public static Date getBeginTime(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate localDate = yearMonth.atDay(1);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));
        return Date.from(zonedDateTime.toInstant());
    }
}
