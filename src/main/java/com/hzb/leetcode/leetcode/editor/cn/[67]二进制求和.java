
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int al = a.length();
        int bl = b.length();
        int ca = 0;
        for (int i = 0; i < Math.max(al, bl); i++) {
            ca += i < a.length() ? (a.charAt(a.length() - 1 -i) -'0') : 0;
            ca += i < b.length() ? (b.charAt(b.length() - 1 -i) - '0') : 0;
            sb.append( ca %2 );
            ca /= 2;
        }
        if(ca >0) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
