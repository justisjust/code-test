package leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    void dfs(int[] nums, int target, int index) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(nums[i] > target) {
                break;
            }
            if(i> index && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, target- nums[i], i+1);
            temp.remove(temp.size() -1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
