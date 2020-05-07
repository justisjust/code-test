package com.hzb.nowcoder;

import java.util.ArrayList;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/12d959b108cb42b1ab72cef4d36af5ec?f=discussion
 * 来源：牛客网
 *
 * 假设字符串abcdef，n=3，设X=abc，Y=def，所以字符串可以表示成XY，
 * 如题干，问如何求得YX。假设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution2 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>(2);

        int i = 0; int j = array.length - 1;
        while (i < j) {
            int temp = array[i] + array[j];
            if(temp == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else if(temp > sum) {
                j--;
            }else {
                i++;
            }
        }

        return list;
    }
}