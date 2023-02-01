package leetcode.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String sym = symbols[i];
            while (num >= value) {
                num -= value;
                sb.append(sym);
            }
            if(num == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
