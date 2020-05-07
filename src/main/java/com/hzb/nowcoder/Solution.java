package com.hzb.nowcoder;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       //设置两个起点
        int left = 1;
        int right =2;
        while (left < right) {
            int temp = (left + right) * (right -left + 1)/2;

            if(temp == sum) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                result.add(list);
                left++;
                //小于给定值，右移
            }else if(temp < sum) {
                right++;
            }else {
                left++;
            }
        }
        return result;
    }
}