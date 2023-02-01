package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), new int[nums.length]);
        return res;
    }

    void dfs(int[] nums, List<Integer> list, int[] used) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //相同数字，前面元素还没用完就用后面的则会和前面排列重复
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == 0) {
                continue;
            }
            if(used[i] == 0) {
                used[i] = 1;
                list.add(nums[i]);
                dfs(nums, list, used);
                list.remove(list.size() -1);
                used[i] =0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
