package com.hzb.test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName TestSet.java
 * @Description TODO
 * @createTime 2022年06月21日 11:29:00
 */
public class TestSet {

    public static void main(String[] args) {
        Receipt receipt1 = new Receipt("1", 1);
        Receipt receipt2 = new Receipt("1", 1);
        Receipt receipt3 = new Receipt("2", 1);

        Set<Receipt> set = new TreeSet<>(new Comparator<Receipt>() {
            @Override
            public int compare(Receipt o1, Receipt o2) {
                if (o1.getId().equals(o2.getId()) &&
                        o1.getType().equals(o2.getType())) {
                    return 0;
                }
                return -1;
            }
        });
        set.add(receipt1);
        set.add(receipt2);
        set.add(receipt3);

        System.out.println(set.size());
    }

    static class Receipt {
        String id;
        Integer type;

        public Receipt(String id, Integer type) {
            this.id = id;
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }
}
