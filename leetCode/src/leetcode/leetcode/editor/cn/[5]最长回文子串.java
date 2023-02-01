package leetcode.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length < 2) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        char[] chars = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        //s[i……j]
        //横 i row
        //纵 j col
        //a b c
        //a b c
        //a b c
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
               if(chars[i] != chars[j]) {
                   dp[i][j] = false;
               }else {
                   if(j- i < 3) {
                       dp[i][j] = true;
                   }else {
                       dp[i][j] = dp[i+1][j-1];
                   }
               }
               if(dp[i][j] && j-i + 1 > maxLen) {
                   maxLen = j-i+1;
                   begin = i;
               }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
