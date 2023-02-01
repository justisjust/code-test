package leetcode.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            sum = (x + y + carry)%10;
            carry = (x+y + carry)/10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
