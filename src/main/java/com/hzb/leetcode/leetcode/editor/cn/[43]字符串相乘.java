
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();

        int[] res = new int[m+n];
        for (int i = m-1; i >=0 ; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n- 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                res[i+j+1] += a * b;
            }
        }
        for (int i = res.length -1; i > 0; i--) {
            res[i-1] += res[i]/10;
            res[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        //判断首尾是否为0,0的话从1开始
        int start = res[0] == 0 ? 1:0;
        while (start < m +n) {
            sb.append(res[start]);
            start++;
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
