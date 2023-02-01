package leetcode.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int i =0,j = height.length -1,res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j-i) * height[i++]) : Math.max(res, (j-i) * height[j--]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
