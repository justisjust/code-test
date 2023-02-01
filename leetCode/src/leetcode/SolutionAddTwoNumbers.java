package leetcode;

import com.alibaba.fastjson.JSON;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName Solution3.java
 * @Description
 * @createTime 2022年03月22日 09:38:00
 */
public class SolutionAddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = getNode(2,4,3);
        ListNode l2 = getNode(5,6,4);

        print(l1);
        print(l2);
        ListNode node = addTwoNumbers(l1, l2);
        print(node);

        System.out.println(Date.from(LocalDate.now().plusDays(-1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }
    private static ListNode getNode(Integer... val) {
        ListNode node = new ListNode();
        ListNode cur = node;
        for (int i = 0; i < val.length; i++) {
            cur.next = new ListNode(val[i]);
            cur = cur.next;
        }
        return node.next;
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个前节点pre
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            int a = sum%10;
            carry = sum/10;
            cur.next = new ListNode(a);
            cur = cur.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry == 1) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
