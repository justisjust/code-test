package leetcode;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName Solution2.java
 * @Description TODO
 * @createTime 2022年03月31日 10:44:00
 */
public class RecursiveList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;

        Node node = recursiveList2(node1);
        while (node !=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static Node recursiveList2(Node list) {
        if(list == null) {
            return list;
        }
        Node pre = null;
        Node cur = list;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static Node recursiveList(Node list) {
        if(list == null) {
            return list;
        }
        Node pre = null;
        Node cur = list;
        while (cur != null) {
            Node temp = cur.next;
            cur.next= pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }
    }
}
