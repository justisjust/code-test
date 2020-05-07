package com.hzb;

import org.apache.commons.lang3.StringUtils;

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
    }
}
