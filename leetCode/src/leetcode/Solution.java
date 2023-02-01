package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2022年03月25日 09:20:00
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = new Solution().subsets(nums);

        for (List<Integer> subset : subsets) {
            System.out.println(JSON.toJSONString(subset));
        }

        Double aDouble = new Double(0.00);
        Double aDouble2 = new Double(0.00);
        System.out.println(aDouble == aDouble2);

        List<String> s = new ArrayList<>();
        s = null;
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        back(nums, 0);
        return res;
    }

    private void back(int[] nums, int i) {
        res.add(new ArrayList<>(list));
        if(i == nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            back(nums, j+1);
            list.remove(list.size() - 1);
        }
    }



}
