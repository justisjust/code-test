package com.hzb.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName TestFor.java
 * @Description TODO
 * @createTime 2022年04月20日 12:18:00
 */
public class TestFor {
    public static void main(String[] args) {
//        System.out.println(Pattern.matches("\\d{4}-\\d{2}-\\d{2}", "null"));
//        System.out.println(Pattern.matches( "\\d{4}-\\d{2}-\\d{2}", "2020-10-12"));
//        System.out.println(Pattern.matches( "\\d{4}-\\d{2}-\\d{2}", "2020-10"));
//        int a =0;
//        for (int i = 0; i < 100; i++) {
//            a = a++;
//        }
//        System.out.println(a);
//        System.out.println((byte)128 );
//        String s2 = new String(new char[] {'H', 'e', 'l', 'l', 'o', '!'});
//
//        Runnable runnable = new Runnable() {
//
//            @Override
//            public void run() {
//
//            }
//        };
        addBinary("11",  "1");

    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int al = sb.length();
        int bl = sb.length();
        int ca = 0;
        for (int i = 0; i < Math.max(al, bl); i++) {
            ca += i < a.length() ? (a.charAt(a.length() - 1 -i) -'0') : 0;
            ca += i < b.length() ? (b.charAt(b.length() - 1 -i) - '0') : 0;
            sb.append( ca %2 );
            ca /= 2;
            System.out.println(sb.toString() +"---");
        }
        if(ca >0) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }

}
