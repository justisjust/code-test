package leetcode.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            while (str.indexOf(common) != 0) {
                common = common.substring(0, common.length() -1);
                if(common.length() == 0) {
                    break;
                }
            }
        }
        return common;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
