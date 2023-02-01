package com.hzb.nowcoder;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName Subject.java
 * @Description TODO
 * @createTime 2022年03月10日 21:41:00
 */
public class Subject {

    public static void main(String[] args) {

        Map<String,Object> resultMap = new HashMap<>(4);
        System.out.println(resultMap.size());

        System.out.println(StringUtils.substring("1", 2));
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        Node node = node1;
        print(node);
        System.out.println();
        print(reverseNode(node));

    }

    private static void print(Node node) {
        do {
            System.out.println(node.getValue());
            node = node.next;
        }while (node != null);


    }

    private static Node reverseNode(Node node) {
        Node pre = null;
        Node cur = node;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    static class Node {
        public String value;
        public Node next;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
