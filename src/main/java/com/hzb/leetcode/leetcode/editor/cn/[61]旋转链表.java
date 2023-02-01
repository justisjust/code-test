
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        int size = 1;
        ListNode cur = head;
        ListNode cur1 = head;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }
        cur.next = head;

        k = k%size;
        for (int i = 1; i < size - k; i++) {
            cur1 = cur1.next;
        }
        head = cur1.next;
        cur1.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
